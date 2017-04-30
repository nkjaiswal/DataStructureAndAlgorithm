#include "Algo.c"

int run(){
	debug = TRUE;
	// struct node* head;
	// struct node* first=NULL;
	// struct node* second=NULL;
	// struct node* tfirst=NULL;
	// struct node* tsecond=NULL;
	// head = create_linked_list(INPUT_AUTO,20);
	// print_linked_list(head);

	// first = head;
	// second = head->next;
	// tfirst = first;
	// tsecond = second;
	// while(first->next->next!=NULL){
	// 	first->next = first->next->next;
	// 	second->next = second->next->next;
	// 	first = first->next;
	// 	second = second->next;
	// }
	// print_linked_list(tfirst);
	// print_linked_list(tsecond);
	// head = sort_linked_list(head,DESC);
	// print_linked_list(head);
	// printf("\nTesting for Sorted: %s\n", (is_sorted_linked_list(head,DESC))==0?"YES":"NO");
	// print_extreme_end_linked_list(head);

	// struct tree_node* tree =  create_tree(INPUT_AUTO,3);
	// print_tree_in_order(tree);
	// print_tree_pre_order(tree);
	// print_tree_post_order(tree);
	// print_tree_level_wise(tree);
	
	// struct queue* q = create_queue();
	// enqueue(q,10); enqueue(q,20); enqueue(q,30); enqueue(q,40);
	// print_queue(q);
	// do{
	// 	printf("\nDequeued: %d",dequeue(q)->value);
	// }while(!is_queue_empty(q));
	// print_queue(q);

	// int price[10]; 
	// getFilledArray(INPUT_RND,price,10);
	// print_array(price,10);
	// find_best_buy_sell_day_for_stock(price,10);

	int data[10]; 
	getFilledArray(INPUT_STD,data,9);
	print_array(data,9);
	find_pivot_element(data,9);
	return 0;
}