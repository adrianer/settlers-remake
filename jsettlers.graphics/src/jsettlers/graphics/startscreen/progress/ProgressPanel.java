package jsettlers.graphics.startscreen.progress;

import go.graphics.GLDrawContext;
import go.graphics.text.EFontSize;
import go.graphics.text.TextDrawer;
import jsettlers.graphics.localization.Labels;
import jsettlers.graphics.progress.EProgressState;
import jsettlers.graphics.startscreen.StartScreen;
import jsettlers.graphics.utils.UIPanel;

/**
 * This content displays progress information for wait screens.
 * 
 * @author michael
 */
public class ProgressPanel extends UIPanel {

	private EProgressState state = EProgressState.LOADING;

	public ProgressPanel() {
		setBackground(StartScreen.BACKGROUND);
	}

	@Override
	public void drawAt(GLDrawContext gl) {
		super.drawAt(gl);

		TextDrawer drawer = gl.getTextDrawer(EFontSize.HEADLINE);

		String text = Labels.getProgress(state);
		drawer.renderCentered(getPosition().getCenterX(), getPosition()
				.getMinY() + 40, text);
	}

	/**
	 * Sets the state to display
	 * 
	 * @param state
	 *            A valid EProgressState
	 * @param progress
	 */
	public void setProgressState(EProgressState state, float progress) {
		this.state = state;
	}

}
