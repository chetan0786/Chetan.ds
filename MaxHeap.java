class MaxHeap
{
   static  void heapify(int arr[],int i)
    {
        int l=2*i+1;
        int max=i;
        int r=2*i+2;
        if(l<arr.length&&arr[l]>arr[max])
        {
            max=l;
        }
        if(r<arr.length&&arr[r]>arr[max])
        {
            max=r;
        }

        if(max!=i)
        {
            int t=arr[i];
            arr[i]=arr[max];
            arr[max]=t;

            heapify(arr, max);
        }
    }

    static void  deletemax(int arr[],int n)
    {
        int max=arr[0];
        arr[0]=arr[arr.length-1];
        arr[arr.length-1]=max;
        n--;
        heapify(arr, 0);
    }

    static void insertheapify(int arr[],int i)
    {
        int p=(i-1)/2;
        int max=i;
        
        while (arr[max] > arr[p]) { 
            int t=arr[p];
            arr[p]=arr[max];
            arr[max]=t;

            max=p;
            p=(max-1)/2;
        } 
    }

    public static void main(String args[])
    {
        int n=7;
        int arr[]=new int[7];
        arr[0]=5;arr[1]=7;arr[2]=4;arr[3]=2;arr[4]=1;arr[5]=11;arr[6]=50;

        for(int i=n/2;i>=0;i--)
        {
            heapify(arr, i);
        }
        
        System.out.println(arr[0]);
        deletemax(arr,n);
        arr[6]=100;
        insertheapify(arr,6);
        
        System.out.println(arr[0]);
    }
}