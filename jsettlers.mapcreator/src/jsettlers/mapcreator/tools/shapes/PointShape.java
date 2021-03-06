package jsettlers.mapcreator.tools.shapes;

import jsettlers.common.position.ShortPoint2D;
import jsettlers.mapcreator.localization.EditorLabels;

/**
 * Only draws a little point at the start position.
 * 
 * @author michael
 *
 */
public class PointShape extends ShapeType {

	@Override
	public void setAffectedStatus(byte[][] fields, ShortPoint2D start,
			ShortPoint2D end) {
		short x = start.x;
		if (x >= 0 && x < fields.length) {
			short y = start.y;
			if (y >= 0 && y < fields[x].length) {
				fields[x][y] = Byte.MAX_VALUE;
			}
		}
	}

	@Override
	public int getSize() {
		return 1;
	}

	@Override
	public String getName() {
		return EditorLabels.getLabel("points");
	}

}
