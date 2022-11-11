import java.util.Arrays;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int split1 = 0, split2 = 0;

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int arrayLength = nums1.length + nums2.length;
        int halfLength = arrayLength / 2;
        int sptitL = 0, splitR = nums1.length;

        while (sptitL <= splitR) {
            split1 = (splitR - sptitL) / 2 + sptitL;
            split2 = halfLength - split1;

            double r1 = (split1 == nums1.length) ? Integer.MAX_VALUE : nums1[split1];
            double l1 = (split1 == 0) ? Integer.MIN_VALUE : nums1[split1 - 1];

            double r2 = (split2 == nums2.length) ? Integer.MAX_VALUE : nums2[split2];
            double l2 = (split2 == 0) ? Integer.MIN_VALUE : nums2[split2 - 1];

            if (r1 < l2)
                sptitL = split1 + 1;
            else if (l1 > r2)
                splitR = split1 - 1;
            else {
                if (arrayLength % 2 == 0)
                    return (Math.min(r1, r2) + Math.max(l1, l2)) / 2;
                else
                    return Math.min(r1, r2);
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid number of args");
        } else {
            int[] nums1 = parseStringToArray(0, args);
            int[] nums2 = parseStringToArray(1, args);
            double result = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
            System.out.println(Double.toString(result));
        }
    }

    private static int[] parseStringToArray(int index, String[] array){
        String str = array[index].replaceAll("\\s+", "");
        String[] strArray = str.split(",");
        int[] nums = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }
        return nums;
    }
}



