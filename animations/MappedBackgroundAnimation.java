public class MappedBackgroundAnimation implements Animation {

	private int universeCount = 0;
	private Universe current = null;
	
	public Universe getNextUniverse() {

		universeCount++;
		
		if (universeCount == 1) {
			return new MappedBackgroundUniverse();
		}
		else {
			this.current = null;
		}
		return this.current;

	}

	public Universe getCurrentUniverse() {
		return this.current;
	}

	@Override
	public Universe switchUniverse(Object event) {
		return null;
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
