//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution
{
    public:
    //Function to perform case-specific sorting of strings.
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(n);
    string caseSort(string str, int n)
    {
        // your code here
        string s1=str;
        sort(s1.begin(),s1.end());
        int up=0,lo=0;
        while(lo<s1.length()) {
            if(s1[lo]>='a') break;
            lo++;
        }
        
        for(int i=0;i<str.length();i++) {
            if(str[i]>='a') {
                str[i]=s1[lo++];
            } else {
                str[i]=s1[up++];
            }
        }
        
        return str;
    }
};

//{ Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		string str;
		cin>>str;
		Solution obj;
		cout<<obj.caseSort (str, n)<<endl;
	}
}
// } Driver Code Ends