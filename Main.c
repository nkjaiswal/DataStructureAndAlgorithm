#include "Algo.c"

int run(){
	debug = TRUE;
	// struct node* head;
	// head = create_linked_list(INPUT_RND,11);
	// print_linked_list(head);
	// head = sort_linked_list(head,DESC);
	// print_linked_list(head);
	// printf("\nTesting for Sorted: %s\n", (is_sorted_linked_list(head,DESC))==0?"YES":"NO");
	// print_extreme_end_linked_list(head);

	struct tree_node* tree =  create_tree(INPUT_AUTO,3);
	// print_tree_in_order(tree);
	print_tree_pre_order(tree);
	// print_tree_post_order(tree);
	print_tree_level_wise(tree);
	
	// struct queue* q = create_queue();
	// enqueue(q,10); enqueue(q,20); enqueue(q,30); enqueue(q,40);
	// print_queue(q);
	// do{
	// 	printf("\nDequeued: %d",dequeue(q)->value);
	// }while(!is_queue_empty(q));
	// print_queue(q);
	return 0;
}