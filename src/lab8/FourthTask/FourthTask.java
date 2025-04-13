package lab8.FourthTask;

public class FourthTask {
    public static String getSpell(String s) {
        String mostPowerful = "";
        int maxCount = 0;

        int n = s.length();
        HashMap<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substr = s.substring(i, j);
                int count = countMap.getOrDefault(substr, 0) + 1;
                countMap.put(substr, count);
                if (count > maxCount || (count == maxCount && substr.length() > mostPowerful.length())) {
                    maxCount = count;
                    mostPowerful = substr;
                }
            }
        }

        return mostPowerful;
    }
}
