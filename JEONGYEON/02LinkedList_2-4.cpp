/*
2.4 분할
    값 x가 주어졌을 때 x보다 작은 노드들을 x보다 크거나 같은 노드들보다 앞에 오도록 하는 코드를 작성하라.
    만약 x가 리스트에 있다면 x는 그보다 작은 원소들보다 뒤에 나오기만 하면 된다.
    즉 원소 x는 ‘오른쪽 그룹’ 어딘가에만 존재하면 된다.
    왼쪽과 오른쪽 그룹 사이에 있을 필요는 없다.
*/
#include <iostream>
#include <vector>
#include <deque>
using namespace std;


// 1. 연결리스트 사용하여 x 보다 작은 수 는 앞에 붙이고, 큰 수는 뒤에 붙임
struct ListElement {
    int data;
    struct ListElement* next;
};

class makeList {
    ListElement *head;
    ListElement *tail;

public:
    makeList() {
        head = NULL;
        tail = NULL;
    }

    ListElement* getHEAD(){
        return head;
    }

    void addElement(int _value){
        ListElement *k = new ListElement();
        k->data = _value;
        k->next = NULL;
        
        if(head == NULL){
            head = k;
            tail = k;
        }else{
            tail->next = k;
            tail = tail->next;
        }
    }

    void addFront(ListElement *p){
        p->next = head;
        head = p;
        if(tail == NULL){
            tail = p;
        }
    }
};

void usedLinkedList(makeList& _list, int x){
    ListElement *currentElement = _list.getHEAD();
    ListElement *nextElement = _list.getHEAD()->next;

    while (nextElement != NULL) {
        if(nextElement->data < x){
            currentElement->next = nextElement->next;
            _list.addFront(nextElement);
            nextElement = currentElement->next;
        }else{
            currentElement = nextElement;
            nextElement = nextElement->next;
        }
    }
    
    // 결과 출력
    ListElement *cur = _list.getHEAD();
    while (cur->next != NULL)
    {
        cout << cur->data << " ";
        cur = cur->next;
    }
    cout << cur->data;
}


// 2. deque 사용하여 x 보다 작은 수 는 앞에 붙이고, 큰 수는 뒤에 붙임
void usedDEQUE(vector<int> & _list, int x){
    deque<int> _deque;
    int listSize = (int)_list.size();

    for(int i=0; i<listSize; i++){
        if(_list[i] < x){
            _deque.push_front(_list[x]);
        }else{
            _deque.push_back(_list[i]);
        }
    }
    
    _list.clear();
    for(int i=0; i<listSize; i++){
        _list.push_back(_deque.front());
        _deque.pop_front();
    }
}

int main(void){ return 0; }