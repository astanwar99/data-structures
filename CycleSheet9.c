#include<stdio.h>
#include<string.h>
struct node
{
    char name[20];
    int marks,regno;
    struct node *next;
}*nw,*nw1,*head1,*head2,*temp1,*temp2,*cur1,*cur2,*rhead,*r1,*tempd;
/* nw: to add node
   head1,head2: for the two lists
   temp1,temp2: for comparison and traversal of the two linked lists
   cur1,cur2: for maintaining the current position of the elements from the lists being compared
   rhead: head pointer of the resultant list
   r1: current position of the element pointer of the resultant list
*/
void l1_get()        //entry of elements in the first linked list
{
    printf("\nEnter values for first list:");
    int ch;
    do
    {
        nw=(struct node*)malloc(sizeof(struct node));
        printf("\nEnter registration number:");
        scanf("%d",&nw->regno);
        printf("\nEnter name:");
        scanf("%s",nw->name);
        printf("\nEnter marks:");
        scanf("%d",&(nw->marks));
        if(head1==NULL)
        {
            head1=nw;
        }
        else
        {
            nw->next=head1;
            head1=nw;
        }
        printf("\nEnter more data(1)");
        printf("\nExit(2):\t");
        scanf("%d",&ch);
    }while(ch!=2);
    display(head1);
}

void l2_get()             //entry of elements in the second linked list
{
    printf("\nEnter values for second list:");
    int ch;
    do
    {
        nw1=(struct node*)malloc(sizeof(struct node));
        printf("\nEnter registration number:");
        scanf("%d",&nw1->regno);
        printf("\nEnter name:");
        scanf("%s",nw1->name);
        printf("\nEnter marks:");
        scanf("%d",&(nw1->marks));
        if(head2==NULL)
        {
            head2=nw1;
        }
        else
        {
            nw1->next=head2;
            head2=nw1;
        }
        printf("\nEnter more data(1)");
        printf("\nExit(2):\t");
        scanf("%d",&ch);
    }while(ch!=2);
    display(head2);
}
void merge()        //adding list2 to the end of list1
{
    temp1=head1;
    while(temp1!=NULL)
    {
        temp1=temp1->next;
    }
    temp1->next=head2;
}

void display(struct node *p)
{
    tempd=p;
    while(tempd!=NULL)
    {
        printf("\nName:%s",tempd->name);
        printf("\nRegNo:%d",tempd->regno);
        printf("\nMarks:%d",tempd->marks);
        tempd=tempd->next;
    }
}

struct node* total_merge(struct node *head1, struct node *head2)
{
    struct node *resultHead, *resultTail, *temp;
    resultHead = resultTail = NULL;
    while(1)
    {
        if(LLOne == NULL)
        {
            resultTail->next = LLTwo;
            break;
        }

        if(LLTwo == NULL)
        {
            resultTail->next = LLOne;
            break;
        }

        /* Check whether current node of
        which Linked list is smaller*/
        if(LLOne->data <= LLTwo->data)
        {
            temp = LLOne;
            LLOne = LLOne->next;
        }
        else
        {
            temp = LLTwo;
            LLTwo = LLTwo->next;
        }
        /*Add smaller node to result linked list  */
        if(resultHead == NULL)
        {
            resultHead = resultTail = temp;
        }
        else
        {
            resultTail->next = temp;
            resultTail = temp;
        }
        resultTail->next = NULL;
    }
    return resultHead;
}

void SelectionSort(struct node *head)
{
	struct node *start = head;
	struct node *traverse;
	struct node *min;

	while(start->next)
	{
		min = start;
		traverse = start->next;

		while(traverse)
		{
			/* Find minimum element from array */
			if( min->marks > traverse->marks )
			{
				min = traverse;
			}

			traverse = traverse->next;
		}
		swap(start,min);			// Put minimum element on starting location
		start = start->next;
	}
}

void swap(struct node *p1, struct node*p2)
{
    char t[20];
	int temp = p1->regno;
	p1->regno = p2->regno;
	p2->regno = temp;
	strcpy(t,p1->name);
	strcpy(p1->name,p2->name);
	strcpy(p2->name,t);
	int t1 = p1->marks;
	p1->marks = p2->marks;
	p2->marks = temp;
}


void unsorted_merge()
{
    printf("\nEnter unsorted lists for sorted merging!");
    l1_get();
    l2_get();
    merge();
    rhead=head1;
    SelectionSort(rhead);
}

void evaluate(int ch)
{
    switch(ch)
    {
        case 1: printf("\nEnter sorted or unsorted list according to your choice");
                l1_get();
                l2_get();
                merge();
                break;
        case 2: printf("\nEnter sorted lists");
                l1_get();
                l2_get();
                rhead=total_merge(head1,head2);
                break;
        case 3: printf("\nEnter UNsorted lists:");
                unsorted_merge();
                break;
        default: printf("\nInvalid Choice! Please try again:");
    }
}
int main()
{
    int ch;
    do
    {
        printf("\n\tMAIN MENU");
        printf("\n1. Merge list 2 at the end of list 1(LOW LEVEL)");
        printf("\n2. Merge list 1 and 2 in order(MID LEVEL)");
        printf("\n3. Enter unsorted lists and merge them(HIGH LEVEL)");
        printf("\n4. Exit");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1: evaluate(1); break;
            case 2: evaluate(2); break;
            case 3: evaluate(3); break;
            case 4: break;
            default: printf("\nInvalid choice! Try again:\t");
        }
    }while(ch!=4);
    return 0;
}
