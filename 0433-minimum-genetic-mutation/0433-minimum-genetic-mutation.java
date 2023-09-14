class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList(); 
        queue.add(startGene);
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        
        HashSet<String> mutated = new HashSet(); 
        mutated.add(startGene);

        HashSet<String> allowedMutations = new HashSet(); 
        for (String b: bank)
            allowedMutations.add(b); 

        int totalMutations = 0;
        while (!queue.isEmpty()){
            int size = queue.size(); 
            for (int i = 0; i < size; i++){
                String current = queue.poll(); 

                if (current.equals(endGene))
                    return totalMutations;
                
                for (int j = 0; j < current.length(); j++){
                    for (char gene: genes){
                        String newString = current.substring(0, j) + gene + 
                            current.substring(j + 1, current.length());

                        //System.out.println(newString);
                        if (mutated.add(newString) && allowedMutations.contains(newString))
                            queue.add(newString);
                    }
                }
            }
            totalMutations++;
        }

        return -1;
    }
}