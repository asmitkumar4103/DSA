class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& a) {

        vector<vector<int>> res;

        sort(a.begin(), a.end());

        int n = a.size();

        int start1 = a[0][0];
        int end1 = a[0][1];

        for (int i = 1; i < n; i++) {

            int start2 = a[i][0];
            int end2 = a[i][1];

            if (end1 >= start2) {
                end1 = max(end1, end2);
            }
            else {
                res.push_back({start1, end1});

                start1 = start2;
                end1 = end2;
            }
        }

        res.push_back({start1, end1});

        return res;
    }
};