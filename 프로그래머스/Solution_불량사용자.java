package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution_불량사용자 {

	private static Set<List<String>> result;
	private static String user_id[], banned_id[];

	public static void main(String[] args) {

		String[] user = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned = { "fr*d*", "abc1**" };
		user_id = user;
		banned_id = banned;
		System.out.println(solution(user, banned));

	}

	private static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		result = new HashSet<>();

		dfs(0, 0, new boolean[user_id.length]);
		answer = result.size();
//		Iterator<List<String>> iterator = result.iterator();
//		while (iterator.hasNext()) {
//			List<String> list = iterator.next();
//			System.out.println(list);
//		}

		return answer;
	}

	private static boolean equal(int i, int banned_idx) {
		String banned = banned_id[banned_idx];
		if (user_id[i].length() == banned.length()) {
			for (int k = 0; k < user_id[i].length(); k++) {
				char temp = user_id[i].charAt(k);
				if (temp != banned.charAt(k) && banned.charAt(k) != '*') {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	private static void dfs(int index, int n, boolean[] visited) {
		if (n == banned_id.length) {
			List<String> list = new ArrayList<>();

			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					list.add(user_id[i]);
				}
			}

			result.add(list);

			
			Iterator<List<String>> iterator = result.iterator();
			while (iterator.hasNext()) {
				List<String> l = iterator.next();
				System.out.println(l);
			}
			return;
		}
		for (int i = 0; i < user_id.length; i++) {

			if (user_id[i].length() == banned_id[index].length() && equal(i, index)) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(index + 1, n + 1, visited);
					visited[i] = false;
				}
			}

		}

	}

}
