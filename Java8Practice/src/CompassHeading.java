
public class CompassHeading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompassHeading mCompassHeading = new CompassHeading();
		System.out.println(mCompassHeading.getDirection(107.91614215137685));
		System.out.println(mCompassHeading.getDirection(9.920833575703856));
		System.out.println(mCompassHeading.getDirection(164.42101941253497));
		System.out.println(mCompassHeading.getDirection(18.492624842200257));
		System.out.println(mCompassHeading.getDirection(344.8602775405673));
		System.out.println(mCompassHeading.getDirection(50.06240334668598));
		System.out.println(mCompassHeading.getDirection(288.72563219670974));
		System.out.println(mCompassHeading.getDirection(116.12529696604679));
		System.out.println(mCompassHeading.getDirection(186.18041188462914));
		System.out.println(mCompassHeading.getDirection(278.86938374428246));
		System.out.println(mCompassHeading.getDirection(204.6865454398376));
		System.out.println(mCompassHeading.getDirection(356.0436128754639));
		System.out.println(mCompassHeading.getDirection(358.848672621366));
		System.out.println(mCompassHeading.getDirection(300.7408030909845));
		System.out.println(mCompassHeading.getDirection(145.58948617509967));
	}

	private String getDirection(double heading) {
		String[] directions = new String[] {
				"n", "ne", "e", "se", "s", "sw", "w", "nw", "n"
		};

		int index = (int) ((heading + 23) / 45);
		return directions[index];
	}
}

