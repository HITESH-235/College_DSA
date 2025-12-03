# Longest Palindromic Substring: return the largest palindromic (in sequence) substring from given string
# LEETCODE link: https://leetcode.com/problems/longest-palindromic-substring/description/

# Brute Force: O(n^3)
# ________________________________________________________________________________________________________________________________
def longestPalindromicSubstring_BF(s):
    def isPalindromic(substring):
        return substring == substring[::-1]
    
    n = len(s)
    res = ""
    for i in range(n):
        for j in range(i,n):
            if isPalindromic(s[i:j+1]) and len(res)<j-i+1:
                res = s[j-i+1]
    return res

# Optimised: O(n^2)
# ________________________________________________________________________________________________________________________________
def longestPalindromicSubstring_Optimised(s):
    # expands if same to both direction and returns that (palindromic) substring
    def expand(s,left,right):
        while left>=0 and right<=len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left+1:right]
# left and right have moved beyond correct palindrome
# thus we need to slice from (left+1) --> (right-1) => (left+1) --> (right); (minding exclusion)

    res = ""
    n = len(s)
    for i in range(n):
        p_odd = expand(s,i,i) # checking for odd* len palindrome (i is center)
        p_even = expand(s,i,i+1) # checking for even* len palindrome

        if len(p_even) > len(res):
            res = p_even
        if len(p_odd) > len(res):
            res = p_odd
    return res
# ________________________________________________________________________________________________________________________________