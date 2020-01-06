package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class CalculateTrainPlatform {
	
	public static void main(String args[]){
		
		int arr[] = {100,140,150,200,200,200,215,400,246,615};
		int dep[] = {110,300,220,230,315,600,315,330,630,700};
		System.out.println("Minimum platforms needed: "+findPlatformsRequiredForStation(arr, dep, 8));
		System.out.println("Minimum platforms needed: "+findPlatformsRequiredForStation(arr, dep));
	}
	static int findPlatformsRequiredForStation(int arr[],int dep[], int n){
		int platform_needed = 0, maxPlatforms = 0;
		int i = 0, j = 0;
		
		while(i < n && j < n){
			if(arr[i] < dep[j]){
				platform_needed++;
				i++;
				if(platform_needed > maxPlatforms){
					maxPlatforms = platform_needed;
				}
				
			}else{
				platform_needed--;
				j++;
			}
		}
		return maxPlatforms;
	}
	static int findPlatformsRequiredForStation(int arr[],int dep[]){
		
		
		Map<Integer,Integer[]> map = new TreeMap<Integer,Integer[]>();
		int nArr = 0;
		int nDep = 0;
		for(int i=0;i<arr.length;i++){
			if( map.get(arr[i]) == null){
				map.put(arr[i], new Integer[] {1,0});
			}else{
				nArr = map.get(arr[i])[0] + 1;
				nDep = map.get(arr[i])[1];
				map.put(arr[i], new Integer[] {nArr,nDep});
			}
		}
		for(int i=0;i<dep.length;i++){
			if(map.get(dep[i]) == null){
				map.put(dep[i], new Integer[] {0,1});
			}else{
				nArr = map.get(dep[i])[0];
				nDep = map.get(dep[i])[1] + 1;
				map.put(dep[i], new Integer[] {nArr,nDep});
			}
			
		}
		int platform_needed = 0, maxPlatforms = 0;
		for (Integer time : map.keySet()) {
			Integer[] timeMap = map.get(time);
			platform_needed += timeMap[0];
			platform_needed -= timeMap[1];
			if(platform_needed < 0){
				platform_needed = 0;
			}
			if(platform_needed >= maxPlatforms){
				maxPlatforms = platform_needed;
			}	
		}

		return maxPlatforms;
	}
	
}
