class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0 || p == null || p.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int match = 0;
        for(int i = 0; i < p.length(); i++) {
            char element = p.charAt(i);
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            char incoming = s.charAt(i);
            if(map.containsKey(incoming)) {
                int elementValue = map.get(incoming);
                elementValue = elementValue - 1;
                if(elementValue == 0) {
                    match += 1;
                }
                map.put(incoming, elementValue);
            }
            if(i >= p.length()) {
                char outgoing = s.charAt(i - p.length());
                if(map.containsKey(outgoing)) {
                    int elementValue = map.getOrDefault(outgoing, 0);
                    elementValue = elementValue + 1;
                    if(elementValue == 1) {
                        match -= 1;
                    }
                    map.put(outgoing, elementValue);
                }
            }
            if(match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
