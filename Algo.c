#include <stdio.h>
#include <time.h>
#include <stdlib.h>

//Global variable for debug mode
int debug = 0;

//Input method
#define INPUT_STD 1
#define INPUT_RND 2
#define INPUT_AUTO 3
#define INPUT_RND_SMALL 4
#define INPUT_RND_MEDIUM 5
#define INPUT_RND_LARGE 6

//Boolean
#define FALSE 0
#define TRUE 1

//Order
#define AESC 1
#define DESC 0


//Direction
#define UP 1
#define DOWN 0
//AUTO increment number
int autoInc;

int run();
//////////////////////////////////////////////////////////////////////////////////////////////
//									INITIALIZATION PART										//
//////////////////////////////////////////////////////////////////////////////////////////////
int main(){
	int ret;
	char c;
	autoInc = 0;
	srand(time(NULL));
	printf("\n\n\n\n\n\n\n\n\n\n-------------------------------------\nNishantSoft v0.1\nC/C++ Pre compiled Data Structure & Algorithm\nnishant.soft04@gmail.com\nStarted\n-------------------------------------\n\n\n\n");
	ret = run();	//user need to do the task in run(), instead of main
	printf("\n\n\n\n-------------------------------------\nSystem is Exiting\nNishantSoft v0.1\n-------------------------------------\n\n\n\n\n\n\n\n\n\nPress Any Key To Continue . . .");
	scanf("%c",&c);
	return ret;
}

//////////////////////////////////////////////////////////////////////////////////////////////
//									DATA STRUCTURE											//
//////////////////////////////////////////////////////////////////////////////////////////////
struct node{
	int value;
	struct node *next;
};
struct node * create_node(int val){
	struct node *new_node = (struct node *) malloc(sizeof(struct node));
	new_node->value = val;
	new_node->next = NULL;
	return new_node;
}

struct tree_node{
	int value;
	struct tree_node *left;
	struct tree_node *right;
};
struct tree_node * create_tree_node(int val){
	struct tree_node *new_tree_node = (struct tree_node *) malloc(sizeof(struct tree_node));
	new_tree_node->value = val;
	new_tree_node->left = NULL;
	new_tree_node->right = NULL;
	return new_tree_node;
}
//////////////////////////////////////////////////////////////////////////////////////////////
//									GENERIC OPERATIONS										//
//////////////////////////////////////////////////////////////////////////////////////////////

int getData(int input_source){
	int val;
	if(input_source == INPUT_STD){
		scanf("%d",&val);
	}else if(input_source == INPUT_RND){
		val = rand();
	}else if(input_source == INPUT_AUTO){
		return autoInc++;
	}else if(input_source == INPUT_RND_SMALL){
		val = rand()%100;
	}else if(input_source == INPUT_RND_MEDIUM){
		val = rand()%10000;
	}else if(input_source == INPUT_RND_LARGE){
		val = rand()%1000000;
	}
	return val;
}

void getFilledArray(int input_source,int arr[], int size){
	int i;
	if(input_source = INPUT_STD){
		printf("Enter Array Elements (integer, size:%d):\n",size);	
	}else{
		printf("Generating Array Elements (integer, size:%d). . .\n",size);
	}
	
	for(i=0;i<size;i++){
		arr[i] = getData(input_source);
	}
}

void print_array(int arr[], int n){
	int i;
	printf("Array: ");
	for(i=0;i<n;i++){
		if(i == n-1){
			printf("%d\n", arr[i]);
		}else{
			printf("%d, ", arr[i]);
		}
	}
}

int array_2d_row = 10;
int array_2d_col = 10;
void getFilled2DArray(int input_source,int arr[array_2d_row][array_2d_col]){
	int i,j;
	int row = array_2d_row, col = array_2d_col;
	if(input_source == INPUT_STD){
		printf("Enter 2D Array Elements (integer, size:%d):\n",row*col);	
	}else{
		printf("Generating 2D Array Elements (integer, size:%d). . .\n",row*col);
	}
	
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			arr[i][j] = getData(input_source);
		}
	}
}

void print_2Darray(int arr[array_2d_row][array_2d_col]){
	int i, row = array_2d_row, col = array_2d_col;
	printf("2D Array: \n\n");
	for(i=0;i<row;i++){
		for(int j=0;j<col;j++){
			printf("%d ",arr[i][j]);
		}
		printf("\n\n");
	}
}

int min(int a,int b){
	return (a>b)?b:a;
}
int max(int a,int b){
	return (a>b)?a:b;
}

void line(char c[]){
	printf("\n");
	for(int i=0;i<30;i++){
		printf("%s",c);
	}
	printf("\n");
}
//////////////////////////////////////////////////////////////////////////////////////////////
//									2D array Operation										//
//////////////////////////////////////////////////////////////////////////////////////////////
void print_diagonal_of_2D_array(int arr[array_2d_row][array_2d_col],int row, int col, int direction){
	
}

void _private_print_diagonal(int arr[array_2d_row][array_2d_col], int i){
	int lmin;
	int n = array_2d_row-1;
	if(i%2 == 0){
		lmin = min(n,i);
		if(lmin == i){
			print_diagonal_of_2D_array(arr, 0, i, DOWN);
		}else{
			print_diagonal_of_2D_array(arr, i-n, n, DOWN);
		}
	}else{
		lmin = min(n,i);
		if(lmin == i){
			print_diagonal_of_2D_array(arr, i, 0, UP);
		}else{
			print_diagonal_of_2D_array(arr, n, i-n, UP);
		}
	}
}

void print_2d_array_diagonally(int arr[array_2d_row][array_2d_col]){
	//iff row==col
	int row = array_2d_row, col = array_2d_col;
	int diagonal = 2*row - 1;
	printf("\nPrining 2D Array Diagonally:\n\n");
	for(int i=0; i<diagonal;i++){
		_private_print_diagonal(arr,i);
	}
}



//////////////////////////////////////////////////////////////////////////////////////////////
//									LINKED LIST												//
//////////////////////////////////////////////////////////////////////////////////////////////
struct node* create_linked_list(int input_source,int node_count){
	int i;
	struct node *new_node;
	struct node *head = NULL;
	struct node *old_node = NULL;
	if(node_count<0){
		node_count = getData(INPUT_RND);
	}
	for(i=0;i<node_count;i++){
		new_node = create_node(getData(input_source));
		if(old_node != NULL){
			old_node->next = new_node;
		}
		if(head == NULL){
			head = new_node;
		}
		old_node = new_node;
		old_node->next = NULL;
	}
	return head;
}

int print_linked_list(struct node *temp){
	int i=0;
	printf("\nHEAD->");
	while(temp!=NULL){
		printf("[%d]->",temp->value);
		temp = temp->next;
		i++;
	}
	printf("NULL");
	return i;
}
struct node* swap_node_linked_list_AESC(struct node* head){ //check and [head->next swap head->next->next]
	struct node* first = head->next;
	struct node* second = first->next;
	struct node* end = second->next;
	if(first->value > second->value){
		head->next = second;
		second->next = first;
		first->next = end;
	}
	return head;
}
struct node* swap_node_linked_list_DESC(struct node* head){ //check and [head->next swap head->next->next]
	struct node* first = head->next;
	struct node* second = first->next;
	struct node* end = second->next;
	if(first->value < second->value){
		head->next = second;
		second->next = first;
		first->next = end;
	}
	return head;
}
int get_node_count_linked_list(struct node* head){
	int i=0;
	while(head!=NULL){
		i++;
		head = head->next;
	}
	return i;
}
struct node* sort_linked_list(struct node* head, int order){
	struct node* outer_loop_node;
	struct node* inner_loop_node;
	struct node* old_node;
	struct node* return_node;
	struct node* dummy_node = create_node(-1);
	int node_count = get_node_count_linked_list(head);
	dummy_node->next = head;
	outer_loop_node = dummy_node;

	while(node_count>0){
		node_count--;
		inner_loop_node=dummy_node;
		while(TRUE){
			if(inner_loop_node->next == NULL){break;} if(inner_loop_node->next->next == NULL){break;}
			if(order == AESC)
				inner_loop_node=swap_node_linked_list_AESC(inner_loop_node);
			else
				inner_loop_node=swap_node_linked_list_DESC(inner_loop_node);
			inner_loop_node = inner_loop_node->next;	
		}
	}


	return_node = dummy_node->next;
	free(dummy_node);
	return return_node;
}

int is_sorted_linked_list(struct node* head,int order){
	int prev = head->value;
	while(head!=NULL){
		if(head->value < prev && order==AESC){
			printf("\nFailed at: %d | %d\n", head->value,prev);
			return -1;
		}
		if(head->value > prev && order==DESC){
			printf("\nFailed at: %d | %d\n", head->value,prev);
			return -1;
		}
		prev = head->value;
		head = head->next;
	}
	return 0;
}

struct node* _private_print_extreme_end_linked_list(struct node* currNode, struct node* head){
	if(currNode == NULL){
		return head;
	}
	head = _private_print_extreme_end_linked_list(currNode->next,head);
	printf("[%d]->[%d]->",currNode->value,head->value);
	return head->next;
}

void print_extreme_end_linked_list(struct node* head){
	int n = get_node_count_linked_list(head);
	n = n/2;
	struct node* temp = head;
	while(n>0){
		n--;
		temp = temp->next;
	}
	printf("\n[HEAD]->");
	_private_print_extreme_end_linked_list(temp,head);
	printf("NULL");
}

//////////////////////////////////////////////////////////////////////////////////////////////
//									QUEUE													//
//////////////////////////////////////////////////////////////////////////////////////////////

struct queue{
	struct node* front;
	struct node* rear;
	int count;
};

struct queue* create_queue(){
	struct queue *q = (struct queue *) malloc(sizeof(struct queue));
	q->front = NULL;
	q->rear = NULL;
	q->count = 0;
	return q;
}
int enqueue(struct queue* q, int val){
	struct node* node = create_node(val);
	if(q->front == NULL){
		q->front = node;
	}
	if(q->rear == NULL){
		q->rear = node;
	}else{
		q->rear->next = node;
		q->rear = node;	
	}
	return ++(q->count);
}
struct node* dequeue(struct queue* q){
	struct node* node = q->front;
	q->front = q->front->next;
	if(q->front == NULL){
		q->rear = NULL;
	}
	return node;
}
void print_queue(struct queue* q){
	print_linked_list(q->front);
}

int is_queue_empty(struct queue* q){
	if(q->front == NULL){
		return TRUE;
	}else{
		return FALSE;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////
//									TREE													//
//////////////////////////////////////////////////////////////////////////////////////////////
struct tree_node* _private_create_tree(int input_source,int level){
	struct tree_node* tree;
	if(level<0){
		return NULL;
	}
	if(level == 0){
		return create_tree_node(getData(input_source));
	}
	tree = create_tree_node(getData(input_source));
	tree->left = _private_create_tree(input_source,level-1);
	tree->right = _private_create_tree(input_source,level-1);
	return tree;
}
struct tree_node* create_tree(int input_source,int level){
	return _private_create_tree(input_source,level);
}

void print_tree_left_root_right(struct tree_node* tree){
	if(tree == NULL){
		return;
	}
	print_tree_left_root_right(tree->left);
	printf("%d, ",tree->value);
	print_tree_left_root_right(tree->right);
}
void print_tree_in_order(struct tree_node* tree){printf("\nIN   ORDER: ");print_tree_left_root_right(tree);}

void print_tree_root_left_right(struct tree_node* tree){
	if(tree == NULL){
		return;
	}
	printf("%d, ",tree->value);
	print_tree_root_left_right(tree->left);
	print_tree_root_left_right(tree->right);
}
void print_tree_pre_order(struct tree_node* tree){printf("\nPRE  ORDER: ");print_tree_root_left_right(tree);}

void print_tree_left_right_root(struct tree_node* tree){
	if(tree == NULL){
		return;
	}
	print_tree_left_right_root(tree->left);
	print_tree_left_right_root(tree->right);
	printf("%d, ",tree->value);
}
void print_tree_post_order(struct tree_node* tree){printf("\nPOST ORDER: ");print_tree_left_right_root(tree);}

void _private_print_tree_level_wise(struct tree_node* tree,struct queue* q){
	if(tree->left != NULL){
		enqueue(q,tree->left->value);	
	}
	if(tree->right != NULL){
		enqueue(q,tree->right->value);	
	}
	if(tree->left != NULL){
		_private_print_tree_level_wise(tree->left,q);
	}
	if(tree->right != NULL){
		_private_print_tree_level_wise(tree->right,q);
	}
}
void print_tree_level_wise(struct tree_node* tree){
	struct queue* q = create_queue();
	enqueue(q,tree->value);
	_private_print_tree_level_wise(tree,q);
	print_queue(q);
}


//////////////////////////////////////////////////////////////////////////////////////////////
//									STOCK BUY SELL PROBLEM									//
//////////////////////////////////////////////////////////////////////////////////////////////
void find_best_buy_sell_day_for_stock(int price[],int n){
	int i,lmax=0,lmin=0;
	for(i=1;i<n;i++){
		if(price[i]<price[i-1]){
			printf("\nBuy on Day %d and Sell on Day %d",lmin,lmax);
			lmax = i;
			lmin = i;
		}
		if(price[i]>price[i-1])
			lmax = i;
	}
	printf("\nBuy on Day %d and Sell on Day %d",lmin,lmax);
}

//////////////////////////////////////////////////////////////////////////////////////////////
//									Pivot Element Finding									//
//////////////////////////////////////////////////////////////////////////////////////////////
void find_pivot_element(int data[],int n){
	int pvt[n];
	int i, lmax=data[0], lmin=data[n-1];

	for(i=0;i<n;i++){
		pvt[i] = 0;
		if(data[i]>=lmax){
			pvt[i]++;
			lmax = data[i];
		}
	}
	for(i=n-1;i>=0;i--){
		if(data[i]<=lmin){
			pvt[i]++;
			lmin = data[i];
		}
	}

	printf("\nDesire Items location are (bese index from 0): ");
	for(i=0;i<n;i++){
		if(pvt[i]==2){
			printf("%d, ",i);
		}
	}
	printf("\b\n");
}

//////////////////////////////////////////////////////////////////////////////////////////////
//									Minimum No of SWAP to make pair							//
//////////////////////////////////////////////////////////////////////////////////////////////
int _private_update_index(int index[],int a,int na, int b, int nb){
	index[a] = na;
	index[b] = nb;
}
int _private_swap_array_element(int arr[],int position_a, int position_b){
	int temp = arr[position_b];
	arr[position_b] = arr[position_a];
	arr[position_a] = temp;
}
// int no_of_swap_to_arrange_in_pair(int pair[],int random_order[],int nPair){
// 	int index[2*n+1];
// 	for(int i=1;i<2*n+1;i++){
// 		index[random_order[i]] = i;
// 	}
// 	for(int j=1;j<2*n+1;j=j+2){
// 		if(pair[random_order[j]] != random_order[j+1]){
// 			swap(random_order,j+1,index[pair[j]]);
// 			_private_update_index(index,)
// 		}
// 	}
// }

//////////////////////////////////////////////////////////////////////////////////////////////
//									Stack using linked_list									//
//////////////////////////////////////////////////////////////////////////////////////////////

struct node* create_stack(){
	return create_linked_list(INPUT_AUTO,0);
}

struct node* push(struct node* stack, int data){
	struct node* newNode = create_node(data);
	newNode->next = stack;
	return newNode;
}

struct node* pop(struct node* stack, int *data){
	*data = stack->value;
	struct node* temp = stack;
	stack = stack->next;
	free(temp);
	return stack;
}

//////////////////////////////////////////////////////////////////////////////////////////////
//									Queue using single stack								//
//////////////////////////////////////////////////////////////////////////////////////////////
struct node* enqueue_queue_using_stack(struct node* stack, int data){
	return push(stack,data);
}

struct node* dequeue_queue_using_stack(struct node* stack, int *data){
	if(stack == NULL){
		return NULL;
	}
	if(stack->next != NULL){
		if(dequeue_queue_using_stack(stack->next,data) == NULL){
			stack->next = NULL;
		}
		return stack;
	}else{
		*data = stack->value;
		return NULL;
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////
//									Print LinkedList Extreme End							//
//////////////////////////////////////////////////////////////////////////////////////////////
struct node* suffle_linked_list_by_extreme_end(struct node* head, struct node* end){
	if(end->next != NULL){
		head = suffle_linked_list_by_extreme_end(head,end->next);
	}
	if(head == NULL){
		return NULL;
	}
	if(head->next == end){
		end->next = NULL; 
		return NULL;
	}
	end->next = head->next;
	head->next = end;
	return head->next->next;
}

//////////////////////////////////////////////////////////////////////////////////////////////
//									Max Diffrence in Tree node and its ancestors			//
//////////////////////////////////////////////////////////////////////////////////////////////
int _private_max_diff_tree_node_and_its_ancestors(struct tree_node* root, int maxv, int diff){
	if(root == NULL){
		return INT_MIN;
	}
	int sol = max(maxv - root->value, diff);
	maxv = max(maxv, root->value);
	// printf("\nRoot:%d, MAXV:%d, SOL:%d",root->value,maxv,sol);
	int final_sol = max(
			_private_max_diff_tree_node_and_its_ancestors(root->left,maxv,sol),
			_private_max_diff_tree_node_and_its_ancestors(root->right,maxv,sol)
		);
	return max(final_sol,sol);
}
int max_diff_tree_node_and_its_ancestors(struct tree_node* root){
	return _private_max_diff_tree_node_and_its_ancestors(root,root->value,INT_MIN);
}
//////////////////////////////////////////////////////////////////////////////////////////////
//						Max sum in 2D array Left-Top Corner to Right-Bottom Corner			//
//////////////////////////////////////////////////////////////////////////////////////////////
int getMaxSum(int mat[array_2d_row][array_2d_col],int row,int col){
	int val = mat[row][col];
	int val1=INT_MIN, val2=INT_MIN;
	int isFirst = TRUE;
	if(row>0){
		isFirst = FALSE;
		val1 = val + mat[row-1][col];
	}
	if(col>0){
		isFirst = FALSE;
		val2 = val + mat[row][col-1];
	}
	if(isFirst){
		return mat[row][col];
	}
	return max(val1,val2);
}
void _private_max_sum_extreme_corner(int mat[array_2d_row][array_2d_col]){
	for(int i=0;i<array_2d_row;i++){
		for(int j=0;j<array_2d_col;j++){
			mat[i][j] = getMaxSum(mat,i,j);
		}
	}
}
int max_sum_extreme_corner(int mat[array_2d_row][array_2d_col]){
	_private_max_sum_extreme_corner(mat);
	return mat[array_2d_row-1][array_2d_col-1];
}
