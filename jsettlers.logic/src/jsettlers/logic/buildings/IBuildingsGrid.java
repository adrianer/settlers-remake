package jsettlers.logic.buildings;

import jsettlers.algorithms.path.dijkstra.DijkstraAlgorithm;
import jsettlers.common.landscape.ELandscapeType;
import jsettlers.common.map.shapes.FreeMapArea;
import jsettlers.common.map.shapes.MapCircle;
import jsettlers.common.material.EMaterialType;
import jsettlers.common.movable.EDirection;
import jsettlers.common.movable.EMovableType;
import jsettlers.common.position.RelativePoint;
import jsettlers.common.position.ShortPoint2D;
import jsettlers.logic.buildings.workers.WorkerBuilding;
import jsettlers.logic.map.newGrid.objects.MapObjectsManager;
import jsettlers.logic.map.newGrid.partition.manager.manageables.interfaces.IBarrack;
import jsettlers.logic.map.newGrid.partition.manager.manageables.interfaces.IDiggerRequester;
import jsettlers.logic.movable.Movable;
import jsettlers.logic.movable.interfaces.AbstractNewMovableGrid;
import jsettlers.logic.player.Player;
import jsettlers.logic.stack.IRequestsStackGrid;

/**
 * This interface defines the methods needed by buildings to exist on a grid.
 * 
 * @author Andreas Eberle
 * 
 */
public interface IBuildingsGrid {

	/**
	 * Gives the height at the given position.
	 * 
	 * @param position
	 *            position to be checked.
	 * @return height at given position.
	 */
	byte getHeightAt(ShortPoint2D position);

	boolean setBuilding(ShortPoint2D position, Building newBuilding); // FIXME create interface for Building to be used by the grid

	/**
	 * Gives the width of the grid.
	 * 
	 * @return width of the grid.
	 */
	short getWidth();

	/**
	 * Gives the height of the grid.
	 * 
	 * @return height of the grid,
	 */
	short getHeight();

	/**
	 * Gives the movable currently located at the given position.
	 * 
	 * @param position
	 *            position to be checked.
	 * @return the movable currently located at the given position<br>
	 *         or null if no movable is located at the given position.
	 */
	Movable getMovable(ShortPoint2D position);

	MapObjectsManager getMapObjectsManager();

	AbstractNewMovableGrid getMovableGrid();

	void requestDiggers(IDiggerRequester requester, byte amount);

	void requestBricklayer(Building building, ShortPoint2D position, EDirection direction);

	IRequestsStackGrid getRequestStackGrid();

	void requestBuildingWorker(EMovableType workerType, WorkerBuilding workerBuilding);

	void requestSoilderable(IBarrack barrack);

	void setBlocked(FreeMapArea buildingArea, boolean blocked);

	void removeBuildingAt(ShortPoint2D pos);

	void pushMaterialsTo(ShortPoint2D position, EMaterialType type, byte numberOf);

	/**
	 * @return dijkstra algorithm to be used by buildings.
	 */
	DijkstraAlgorithm getDijkstra();

	/**
	 * Occupies the given area for the given player.
	 * 
	 * @param player
	 * @param influencingArea
	 */
	void occupyAreaByTower(Player player, MapCircle influencingArea);

	/**
	 * Frees the area occupied by the tower at the given position.
	 * 
	 * @param towerPosition
	 */
	void freeAreaOccupiedByTower(ShortPoint2D towerPosition);

	/**
	 * Changes the player of the tower at the given position to the given new player. The given groundArea will always become occupied by the new
	 * player.
	 * 
	 * @param towerPosition
	 * @param newPlayer
	 * @param groundArea
	 */
	void changePlayerOfTower(ShortPoint2D towerPosition, Player newPlayer, final FreeMapArea groundArea);

	/**
	 * Checks if the given relative area has the flattened landscape type and the given height.
	 * 
	 * @param position
	 * @param positions
	 * @param expectedHeight
	 * @return Returns true if the area has the given height and the landscape type {@link ELandscapeType}.FLATTENED.
	 */
	boolean isAreaFlattenedAtHeight(ShortPoint2D position, RelativePoint[] positions, byte expectedHeight);

	/**
	 * 
	 * @param buildingPosition
	 * @param workAreaCenter
	 * @param radius
	 * @param draw
	 *            If true, the work area circle is drawn,<br>
	 *            if false, it is removed.
	 */
	void drawWorkAreaCircle(ShortPoint2D buildingPosition, ShortPoint2D workAreaCenter, short radius, boolean draw);

}
