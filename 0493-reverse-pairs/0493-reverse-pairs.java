class Solution {
    static int count;
    public int reversePairs(int[] nums) {
        count=0;
        mergeSort(nums);
        return (int)count;
    }
        public static void mergeSort(int[] arr){
        int n= arr.length; // array ki length
        if(n<=1) return; // base case
        // do naya adhe size ka khali array
        int[] a = new int[n/2]; 
        int[] b = new int[n-n/2];
        // copy paste
        int idx=0;
        for(int i=0; i<a.length;i++) a[i] = arr[idx++];
        for(int i=0; i<b.length;i++) b[i] = arr[idx++];
      // recall
      mergeSort(a);
      mergeSort(b);
      countReversePairs(a, b);
      merge(a,b,arr);
   }
   private static void countReversePairs(int[] a, int[] b) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            while (j < b.length && (long) a[i] > 2L * b[j]) {
                j++;
            }
            count += j;
        }
    }
   public static void merge(int[]a, int[] b, int[] c){
    int i=0,j=0,k=0;
    while(i<a.length && j<b.length){
        if(a[i]<= b[j]) c[k++]= a[i++];
        else  c[k++]=b[j++];
    }
    while(i<a.length) c[k++]= a[i++];
    while(j<b.length) c[k++]= b[j++];
   
   }
}