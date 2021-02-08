
public class LongestTurbulentSubarray {
    
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) return arr.length; 
        int left = 0, right = 1, max = 1, flag = 0;
        if (arr[left] > arr[right]) flag = -1;
        else if (arr[left] < arr[right]) flag = 1;
        if (flag != 0) max = 2;
        while (right < arr.length - 1) {
            if (arr[right] > arr[right + 1] && flag == 1)
                flag = -1;
            else if (arr[right] < arr[right + 1] && flag == -1)
                flag = 1;
            else {
                if (arr[right] > arr[right + 1]) flag = -1;
                else if (arr[right] < arr[right + 1]) flag = 1;
                else flag = 0;
                left = right;
            }
            right++;
            if (flag != 0)
                max = Math.max(max, 1 + right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };
        System.out.println(new LongestTurbulentSubarray().maxTurbulenceSize(arr));
    }

}
