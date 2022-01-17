#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

/*
 stack 내 상위 top에 현재까지의 최소값 갖고서 push > pair 사용
 Runtime: 37 ms
 Memory Usage: 16.4 MB
 */ 
class MinStack {
private:
    stack<pair<int, int>> _st;

public:
    MinStack() {
        
    }
    
    void push(int val) {
        if(_st.empty()){
            _st.push(make_pair(val, val));
        } else{
            _st.push(make_pair(val, min(_st.top().second, val)));
        }
    }
    
    void pop() {
        _st.pop();
    }
    
    int top() {
        return _st.top().first;
    }
    
    int getMin() {
        return _st.top().second;
    }
};