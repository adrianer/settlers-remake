package jsettlers.logic.algorithms.path.astar.normal;

import jsettlers.logic.algorithms.path.astar.queues.IRankSupplier;

public interface IAStarHeapable extends IRankSupplier {
	int getHeapIdx(int elementID);

	void setHeapIdx(int elementID, int idx);

}
