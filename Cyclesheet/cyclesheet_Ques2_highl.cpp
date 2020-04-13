
#include<iostream>
#include<string>
using namespace std;

struct stack
{
    string single[40];
    int back,forward;
}st;

void b_push_new()
{

    cout<<"\nEnter website URL:";
    cin>>st.single[++st.back];

}

void b_push()
{
    if (st.back==19)
    cout<<"\nStack overflow";
    else
    {
        st.single[++st.back]=st.single[st.forward];
    }
}


void f_push()
{
    st.single[--st.forward]=st.single[st.back];
}

void b_pop()
{
    st.back--;
}

void f_pop()
{
    st.forward++;
}

void display()
{
    cout<<"\nCurrent website:"<<st.single[st.back]<<"\n";
    cout<<"\nback->"<<st.single[st.back-1]<<"\n";
    for(int i=st.back-2;i>=0;i--)
    {
        cout<<"      "<<st.single[i]<<"\n";
    }
    cout<<"\nforward->"<<st.single[st.forward]<<"\n";
    for(int i=st.forward+1;i<40;i++)
    {
        cout<<"         "<<st.single[i]<<"\n";
    }
}

int main()
{
    int i,n,ch;
    st.back=-1;
    st.forward=40;

    cout<<"\n===========================\n"
        <<"Enter a choice\n"
        <<"1.Browse new website\n"
        <<"2.Back\n"
        <<"3.Forward\n"
        <<"4.Display status\n"
        <<"5.Exit\n"
        <<"===========================\n";

    do
    {
        cout<<"\nChoice: ";
        cin>>ch;

        switch(ch)
        {
            case 1: b_push_new();
                    break;
            case 2:
                    if(st.back==0)
                    cout<<"\nNO RECORD AVAILABLE\n";
                    else
                    {
                        f_push();
                        b_pop();
                    }
                    break;
            case 3:
                    if(st.forward==40)
                    cout<<"\nNO RECORD AVAILABLE\n";
                    else
                    {
                        b_push();
                        f_pop();
                    }
                    break;
            case 4: display();
                    break;
            case 5: break;
            default:cout<<"\nWrong choice\n";
                    break;

        }
    }while(ch!=5);
    return 0;

}
