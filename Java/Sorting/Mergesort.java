public class Mergesort {
    public static ArrayList<Integer> mergesort(ArrayList<Integer> list){
        if( list.size() <= 1) return list;

        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int mid = list.size()/2;
        for(int i = 0; i<mid; i++){
            left.add( list.get(i));
        }
        for(int j = mid; j < list.size(); j++){
            right.add( list.get(j) );
        }

        left = mergesort(left);
        right = mergesort(right);
        return merge(left,right);
    }

    static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(left.size() > 0 || right.size() > 0){
            if(left.size()>0 && right.size()>0) {
                if (left.get(0) <= right.get(0)) {
                    result.add(left.get(0));
                    left.remove(0);
                } else {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
            else if( left.size()>0){
                result.add(left.get(0));
                left.remove(0);
            }
            else if( right.size()>0){
                result.add(right.get(0));
                right.remove(0);
            }
        }
        return result;
    }
}
