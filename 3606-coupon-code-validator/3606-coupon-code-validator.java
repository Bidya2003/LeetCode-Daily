class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();

        for(int i=0; i<code.length; i++){
            if(isActive[i]==false || code[i].length() == 0)
                continue;
            
            if(businessLine[i].equals("electronics") || 
                businessLine[i].equals("grocery") || 
                businessLine[i].equals("pharmacy") || 
                businessLine[i].equals("restaurant"))
            {
                boolean valid = true;
                for(int c=0; c<code[i].length(); c++){
                    char ch = code[i].charAt(c);

                    if (!((ch >= 'a' && ch <= 'z') ||
                        (ch >= 'A' && ch <= 'Z') ||
                        (ch >= '0' && ch <= '9') ||
                        ch == '_')) {

                        valid = false;
                        break;
                    }
                }
                if(valid){
                    String str = businessLine[i];
                    if(str.equals("electronics")){
                        electronics.add(code[i]);
                    }
                    else if(str.equals("grocery")){
                        grocery.add(code[i]);
                    }
                    else if(str.equals("pharmacy")){
                        pharmacy.add(code[i]);
                    }
                    else if(str.equals("restaurant")){
                        restaurant.add(code[i]);
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>();

        if(electronics.size() != 0) {
            Collections.sort(electronics);
            for(String str : electronics){
                ans.add(str);
            }
        }
        if(grocery.size() != 0){
            Collections.sort(grocery);
            for(String str : grocery){
                ans.add(str);
            }
        }
        if(pharmacy.size() != 0){
            Collections.sort(pharmacy);
            for(String str : pharmacy){
                ans.add(str);
            }
        }
        if(restaurant.size() != 0){
            Collections.sort(restaurant);
            for(String str : restaurant){
                ans.add(str);
            }
        }

        return ans;
    }
}