class Solution {
public:
    bool validUtf8(vector<int>& data) {
        int strt = -1;
        
        for(int i=0;i<data.size();i++) {
            
            if(is_set(data[i],7)) {
                if(is_set(data[i],6)) {
                    if(is_set(data[i],5)) {
                        if(is_set(data[i],4)) {
                            if(is_set(data[i],3)) {
                                // Invalid Case
                                return false;
                            } else {
                                // 4 - Bytes
                                if(strt!=-1) return false;
                                strt=4;
                            }
                        } else {
                            // 3 - Bytes
                            if(strt!=-1) return false;
                            strt=3;
                        }
                    } else {
                        // 2 - Bytes
                        if(strt!=-1) return false;
                        strt=2;
                    }
                } else {
                    // next - Bytes
                    if(strt==-1) return false;
                    strt--;
                    if(strt==1) strt=-1;
                }
            } else {
                // 1-Bytes
                if(strt!=-1) return false;
            }
            
        }
        
        if(strt!=-1) return false;
        return true;
    }
    bool is_set(int n,int idx) {
        return (n&(1<<idx))!=0;
    }
};
