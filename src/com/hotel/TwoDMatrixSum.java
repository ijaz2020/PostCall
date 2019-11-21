package com.hotel;

public class TwoDMatrixSum {

    public static void main(String args[]){

        int matrix[][]={
                {6,-5,-7,4,-4},
                {-9,3,-6,5,2},
                {-10,4,7,-6,3},
                {-8,9,-3,3,-7}
        };

        Rectangle maxSumRectangle= maxSum(matrix);

        System.out.println("Rectangle Sum: "+maxSumRectangle.interiorSum);

        System.out.println("Left Index: "+maxSumRectangle.leftBorderIndex);
        System.out.println("Right Index: "+maxSumRectangle.rightBorderIndex);
        System.out.println("Top Index: "+maxSumRectangle.topBorderIndex);
        System.out.println("Bottom Index: "+maxSumRectangle.bottomBorderIndex);
    }

    private static Rectangle maxSum(int matrix[][]){

        int rows=matrix.length;
        int cols=matrix[0].length;
        int runningRowSums[]=new int[rows];

        Rectangle maxRectangle=new Rectangle();

        for(int left=0;left<cols; left++){
            for(int i=0;i<rows; i++){
                runningRowSums[i]=0;
            }
            for(int right=left;right<cols; right++){

                for(int i=0;i<rows; i++){
                    runningRowSums[i]+=matrix[i][right];
                }

                KadaneResult kadaneResult=kadane(runningRowSums);

                if(kadaneResult.maxSum>maxRectangle.interiorSum){
                    maxRectangle.interiorSum=kadaneResult.maxSum;

                    maxRectangle.leftBorderIndex=left;
                    maxRectangle.rightBorderIndex=right;
                    maxRectangle.topBorderIndex=kadaneResult.startIndex;
                    maxRectangle.bottomBorderIndex=kadaneResult.endIndex;
                }

            }

        }

        return maxRectangle;
    }


    private static KadaneResult kadane(int arr[]){


        int bestMaxSoFar=0;
        int maxRegionStart=-1;
        int maxRegionEnd=-1;

        int currentStart=0;
        int bestMaxAtThisIndex=0;

        for(int i=0;i<arr.length;i++){

            bestMaxAtThisIndex+=arr[i];

            if(bestMaxAtThisIndex< 0){
                bestMaxAtThisIndex=0;
                currentStart=i+1;
            }
            if(bestMaxAtThisIndex>bestMaxSoFar){
                maxRegionStart=currentStart;
                maxRegionEnd=i;
                bestMaxSoFar=bestMaxAtThisIndex;
            }

        }

        return new KadaneResult(bestMaxSoFar,maxRegionStart,maxRegionEnd);
    }

    private static class KadaneResult {

        int maxSum;
        int startIndex;
        int endIndex;

        public KadaneResult(int maxSum, int startIndex, int endIndex) {
            this.maxSum = maxSum;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

    }

    private static class Rectangle {

        int interiorSum;

        int leftBorderIndex;
        int rightBorderIndex;
        int topBorderIndex;
        int bottomBorderIndex;

    }

}
