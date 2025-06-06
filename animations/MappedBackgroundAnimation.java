public class MappedBackgroundAnimation implements Animation {

	private Universe current = new MappedBackgroundUniverse();
	private boolean universeSwitched = false;
	private boolean animationComplete = false;
	
	public Universe switchUniverse(Object event) {

		universeSwitched = true;
		//there is only the initial universe; when a switch is called for, set current to null;
		animationComplete = true;
		
		return current;

	}

	public Universe getCurrentUniverse() {
		return current;
	}

	@Override
	public boolean getUniverseSwitched() {
		return false;
	}

	@Override
	public void acknowledgeUniverseSwitched() {		
	}

	@Override
	public boolean isComplete() {
		return false;
	}

	@Override
	public void setComplete(boolean complete) {
	}

	@Override
	public void update(AnimationFrame frame, long actual_delta_time) {
	}

}
