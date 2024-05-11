import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class C {
    static final int MOD = (int)1e9 + 7;
    static FastScanner in = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {

        int T = in.nextInt();

        while(T-- > 0) {

            

        }

        out.close();
    }

    // Remember to initialize the whole adj list
    // with empty arraylist.
    // static void dfs(int node) {
        // visited[node] = true;
        // Just after entering the node.

       //  for (int child : g[node]) {
            // Take action on each child
          //   if (!visited[child])
            //    dfs(child);
        //}

        // Take action after exiting all the
        // childs

        

    // }

    static long binPow(long a, long n, long mod) {
        long res = 1L;

        while(n > 0L) {
            if((n & 1L) == 1L) res = ((a % mod) * (res % mod)) % mod;

            a = ((a % mod) * (a % mod)) % mod;
            n >>= 1;
        }

        return res;
    }

    static int upperBound(int[] a, int l, int r, int target) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;

            if (a[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    static int lowerBound(int[] a, int l, int r, int target) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;

            if (a[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    static void push(Map<Integer, Integer> mp, int k, int v) {
        if (mp.containsKey(k)) {
            mp.put(k, mp.get(k) + v);
        } else {
            mp.put(k, v);
        }
    }

    static void pull(Map<Integer, Integer> mp, int k, int v) {
        int x = mp.get(k);

        if (v >= x)
            mp.remove(k);
        else
            mp.put(k, x - v);
    }

    static boolean isPrime(long n) {
        if (n < 2)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (long i = 6; i * i <= n; i += 6) {
            if ((n % (i - 1) == 0) || (n % (i + 1) == 0)) {
                return false;
            }
        }

        return true;
    }

    static long gcd(long a, long b) {
        return b == 0L ? a : gcd(b, a % b);
    }

    static void reverse(int[] a, int l, int r) {
        while (l < r)
            swap(a, l++, r--);
    }

    static void reverse(long[] a, int l, int r) {
        while (l < r)
            swap(a, l++, r--);
    }

    static void swap(long[] a, int l, int r) {
        long temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    static void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    static void ruffleSort(long[] a, int l, int r) {
        shuffleArray(a, l, r);
        Arrays.sort(a, l, r + 1);
    }

    static void ruffleSort(int[] a, int l, int r) {
        shuffleArray(a, l, r);
        Arrays.sort(a, l, r + 1);
    }

    static void shuffleArray(int[] arr, int l, int r) {
        Random rnd = new Random();
        for (int i = l; i <= r; ++i) {
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(r - i + 1);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }

    static void shuffleArray(long[] arr, int l, int r) {
        Random rnd = new Random();
        for (int i = l; i <= r; ++i) {
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(r - i + 1);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }

    static long[] readArrayL(int n) {
        long[] a = new long[n + 1];

        for (int i = 1; i <= n; ++i) {
            a[i] = in.nextLong();
        }

        return a;
    }

    static ArrayList<Integer> readList(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        return list;
    }

    static int[] readArray(int n) {
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        return arr;
    }

    static class FastScanner {
        // I don't understand how this works lmao
        private int BS = 1 << 16;
        private char NC = (char) 0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private InputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1)
                    return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC)
                c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-')
                    neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                cnt *= 10;
            }
            return neg ? -res : res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / cnt;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32)
                c = getChar();
            while (c > 32) {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32)
                c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if (c > 32)
                return true;
            while (true) {
                c = getChar();
                if (c == NC)
                    return false;
                else if (c > 32)
                    return true;
            }
        }
    }
}
