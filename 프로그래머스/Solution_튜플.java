package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_Æ©ÇÃ {
	// https://programmers.co.kr/learn/courses/30/lessons/64065

	static class Point {
		int index, size;

		public Point(int index, int size) {
			super();
			this.index = index;
			this.size = size;
		}
	}

	public static void main(String[] args) {
		String s = "{{123}}";
		System.out.println(Arrays.toString(solution(s)));

	}

	private static int[] solution(String s) {

		List<String[]> al = new ArrayList<>();
		List<Point> sizeAl = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(s, "{}");

		int idx = 0;
		while (st.hasMoreTokens()) {
			String[] temp = st.nextToken().split(",");
			if (temp.length > 0) {
				al.add(temp);
				sizeAl.add(new Point(idx, temp.length));
				idx++;
			}
		}
		Collections.sort(sizeAl, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.size - o2.size;
			}

		});
//		for (int i = 0; i < sizeAl.size(); i++) {
//			System.out.println(sizeAl.get(i).index);
//		}
		int[] answer = new int[sizeAl.get(sizeAl.size() - 1).size];

		int temp = Integer.parseInt(al.get(sizeAl.get(0).index)[0]);
		answer[0] = temp;
		System.out.println(temp);
		for (int i = 1; i < al.size(); i++) {
			System.out.println("idx:" + i + " / al.get:" + Arrays.toString(al.get(sizeAl.get(i).index)));
			for (int j = 0; j < al.get(sizeAl.get(i).index).length; j++) {
				boolean flag = true;
				for (int k = 0; k < i; k++) {
					int tmp = Integer.parseInt(al.get(sizeAl.get(i).index)[j]);
					System.out.println(Arrays.toString(al.get(sizeAl.get(i).index)));
					System.out.println(Arrays.toString(answer));
					System.out.println(al.get(sizeAl.get(i).index)[j]+" vs "+answer[k]);
					if (answer[k] == tmp) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer[i] = Integer.parseInt(al.get(sizeAl.get(i).index)[j]);
					System.out.println("Ãß°¡:"+al.get(sizeAl.get(i).index)[j]);
					break;
				}
			}

		}
		return answer;
	}

}
