package norivensuu.plushified.block;

import com.mojang.serialization.MapCodec;
import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import norivensuu.plushified.block.entity.PlushieBlockEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.Objects;

import static norivensuu.plushified.registry.SoundEventRegistry.PLUSHIE_PAT_SOUND_EVENT;
import static norivensuu.plushified.shape.ShapeUtils.rotateShape;

public class Plushie extends BlockWithEntity implements Waterloggable, BlockEntityProvider {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public BlockEntityType<PlushieBlockEntity> PLUSHIE_BLOCK_ENTITY_TYPE;

    public Plushie(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false));
        PLUSHIE_BLOCK_ENTITY_TYPE = BlockEntityType.Builder.create(this::initializeBlockEntity, this).build();
    }

    public PlushieBlockEntity initializeBlockEntity(BlockPos pos, BlockState state) {
        return new PlushieBlockEntity(this, pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView blockView, BlockPos pos, ShapeContext context) {
        VoxelShape voxel =
                Block.createCuboidShape(
                        3, 0, 4,
                        13,16,14);
        //return voxel;
        return switch (state.get(Properties.HORIZONTAL_FACING)) {
            case EAST -> rotateShape(Direction.EAST, voxel);
            case SOUTH -> rotateShape(Direction.SOUTH, voxel);
            case WEST -> rotateShape(Direction.WEST, voxel);
            default -> voxel;
        };
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING, WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return Objects.requireNonNull(super.getPlacementState(ctx))
                .with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).isOf(Fluids.WATER));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            world.playSound(null, pos, PLUSHIE_PAT_SOUND_EVENT, SoundCategory.BLOCKS, 1f, (float) ThreadLocalRandom.current().nextInt(9, 11 + 1) / 10);
            ((PlushieBlockEntity) world.getBlockEntity(pos)).triggerAnim("controller", "pat");
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PlushieBlockEntity(this, pos, state);
    }
}