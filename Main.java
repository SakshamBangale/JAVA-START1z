import java.util.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== 10 Java Questions — Demonstration ===\n");

        // 1. Reverse a string
        String s1 = "Hello World";
        System.out.println("1) Reverse a string");
        System.out.println("   Input: " + s1);
        System.out.println("   Output: " + reverseString(s1));
        System.out.println();

        // 2. Palindrome check
        String s2 = "racecar";
        System.out.println("2) Palindrome check");
        System.out.println("   Input: " + s2);
        System.out.println("   Is palindrome? " + isPalindrome(s2));
        System.out.println();

        // 3. Factorial (BigInteger)
        int nFact = 20;
        System.out.println("3) Factorial (BigInteger)");
        System.out.println("   Input: " + nFact);
        System.out.println("   Output: " + factorial(nFact));
        System.out.println();

        // 4. Nth Fibonacci (BigInteger)
        int nFib = 50;
        System.out.println("4) Nth Fibonacci (BigInteger)");
        System.out.println("   Input: " + nFib);
        System.out.println("   Output: " + fibonacci(nFib));
        System.out.println();

        // 5. Prime check and count primes up to N
        int p = 97;
        int upTo = 100;
        System.out.println("5) Primes");
        System.out.println("   Is " + p + " prime? " + isPrime(p));
        System.out.println("   Number of primes <= " + upTo + " : " + countPrimesUpTo(upTo));
        System.out.println();

        // 6. Sort an array
        int[] arr = {5, 3, 8, 1, 2};
        System.out.println("6) Sort an array");
        System.out.println("   Input: " + Arrays.toString(arr));
        System.out.println("   Output: " + Arrays.toString(sortArray(arr)));
        System.out.println();

        // 7. Max and min in an array
        System.out.println("7) Find max and min in an array");
        System.out.println("   Input: " + Arrays.toString(arr));
        int[] mm = maxMin(arr);
        System.out.println("   Max: " + mm[0] + ", Min: " + mm[1]);
        System.out.println();

        // 8. Anagram check
        String a1 = "listen";
        String a2 = "silent";
        System.out.println("8) Anagram check");
        System.out.println("   Inputs: \"" + a1 + "\", \"" + a2 + "\"");
        System.out.println("   Are anagrams? " + areAnagrams(a1, a2));
        System.out.println();

        // 9. GCD and LCM
        long x = 21L, y = 6L;
        System.out.println("9) GCD and LCM");
        System.out.println("   Inputs: " + x + ", " + y);
        System.out.println("   GCD: " + gcd(x, y));
        System.out.println("   LCM: " + lcm(x, y));
        System.out.println();

        // 10. Count vowels and character frequency
        String t = "Programming in Java!";
        System.out.println("10) Count vowels and character frequency");
        System.out.println("    Input: " + t);
        System.out.println("    Vowel count: " + countVowels(t));
        System.out.println("    Character frequencies: " + charFrequency(t));
        System.out.println();

        System.out.println("=== End ===");
    }

    // 1. Reverse a string
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 2. Palindrome check (case-sensitive simple check)
    public static boolean isPalindrome(String s) {
        String rev = reverseString(s);
        return s.equals(rev);
    }

    // 3. Factorial using BigInteger
    public static BigInteger factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    // 4. Nth Fibonacci using BigInteger (0-based: fibonacci(0)=0)
    public static BigInteger fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        BigInteger a = BigInteger.ZERO, b = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger next = a.add(b);
            a = b;
            b = next;
        }
        return b;
    }

    // 5a. Simple primality test
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        int r = (int)Math.sqrt(n);
        for (int i = 3; i <= r; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 5b. Count primes up to n using Sieve of Eratosthenes
    public static int countPrimesUpTo(int n) {
        if (n < 2) return 0;
        boolean[] isComposite = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i * i <= n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) if (!isComposite[i]) count++;
        return count;
    }

    // 6. Sort an array (returns a sorted copy)
    public static int[] sortArray(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }

    // 7. Find max and min in an array, returns [max, min]
    public static int[] maxMin(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array must be non-empty");
        int max = arr[0], min = arr[0];
        for (int v : arr) {
            if (v > max) max = v;
            if (v < min) min = v;
        }
        return new int[]{max, min};
    }

    // 8. Anagram check (case-insensitive, ignores spaces)
    public static boolean areAnagrams(String s1, String s2) {
        String a = s1.replaceAll("\\s+", "").toLowerCase();
        String b = s2.replaceAll("\\s+", "").toLowerCase();
        if (a.length() != b.length()) return false;
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        return Arrays.equals(ca, cb);
    }

    // 9. GCD and LCM (non-negative longs)
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        // Use BigInteger to avoid overflow when multiplying
        BigInteger ba = BigInteger.valueOf(a);
        BigInteger bb = BigInteger.valueOf(b);
        BigInteger bgcd = BigInteger.valueOf(gcd(a, b));
        BigInteger blcm = ba.multiply(bb).divide(bgcd).abs();
        return blcm.longValue();
    }

    // 10a. Count vowels in a string
    public static int countVowels(String s) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) >= 0) count++;
        }
        return count;
    }

    // 10b. Character frequency (returns a map with counts for visible characters)
    public static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) continue; // skip spaces for readability
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}