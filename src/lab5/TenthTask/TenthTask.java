package lab5.TenthTask;

import java.util.*;

public class TenthTask {

    private static final int P = 1237143;
    private static final long MOD = (long) Math.pow(2, 32);

    public static class SubstringHelper {
        private final int[] tiles;
        private final long[] pPowers;
        private final long[] hashPrefix;
        private final long[] reverseHashPrefix;

        public SubstringHelper(int[] tiles) {
            this.tiles = tiles;
            this.pPowers = new long[tiles.length];
            this.hashPrefix = new long[tiles.length];
            this.reverseHashPrefix = new long[tiles.length];
            pPowersCalc();
            calculateHashes();
        }

        // Вычисление степеней P
        private void pPowersCalc() {
            pPowers[0] = 1;
            for (int i = 1; i < tiles.length; i++) {
                pPowers[i] = (pPowers[i - 1] * P) % MOD;
            }
        }

        // Вычисление префиксных хешей
        // Вычисление префиксных хешей
        private void calculateHashes() {
            for (int i = 0; i < tiles.length; i++) {
                if (i > 0) {
                    hashPrefix[i] = (hashPrefix[i - 1] + pPowers[i] * tiles[i]) % MOD;
                    reverseHashPrefix[i] = (reverseHashPrefix[i - 1] + pPowers[i] * tiles[tiles.length - 1 - i]) % MOD;
                } else {
                    hashPrefix[i] = (pPowers[i] * tiles[i]) % MOD;
                    reverseHashPrefix[i] = (pPowers[i] * tiles[tiles.length - 1 - i]) % MOD;
                }
            }
        }


        // Извлечение хеша подстроки
        private long extractSubstringHash(int leftInd, int rightInd, boolean reverse) {
            long[] currentPrefix = reverse ? reverseHashPrefix : hashPrefix;
            long substringHash = currentPrefix[rightInd];
            if (leftInd > 0) {
                substringHash -= currentPrefix[leftInd - 1];
            }
            return (substringHash + MOD) % MOD;
        }

        // Сравнение подстрок
        public boolean compareSubstrings(int left1, int right1, int left2, int right2) {
            long part1 = (extractSubstringHash(left1, right1, false) * pPowers[left2]) % MOD;
            long part2 = (extractSubstringHash(left2, right2, true) * pPowers[left1]) % MOD;
            return part1 == part2;
        }
    }

    // Реверс списка
    public static void listReverser(List<Integer> list) {
        int cur1 = 0;
        int cur2 = list.size() - 1;
        while (cur1 < cur2) {
            Collections.swap(list, cur1, cur2);
            cur1++;
            cur2--;
        }
    }

    // Основной алгоритм
    public static List<Integer> calculate(SubstringHelper subHelper, int[] tiles) {
        List<Integer> result = new ArrayList<>();
        int mirrorIndex = tiles.length / 2;
        int reverseStart = 0;
        int reverseEnd = mirrorIndex - 1;
        while (mirrorIndex != 0) {
            if (subHelper.compareSubstrings(0, mirrorIndex - 1, reverseStart, reverseEnd)) {
                result.add(tiles.length - mirrorIndex);
            }
            mirrorIndex--;
            reverseStart += 2;
            reverseEnd++;
        }
        result.add(tiles.length);
        listReverser(result);
        return result;
    }

    // Основной метод
    public static List<Integer> getNumbers(int[] tiles) {
        SubstringHelper subHelper = new SubstringHelper(tiles);
        return calculate(subHelper, tiles);
    }
}
