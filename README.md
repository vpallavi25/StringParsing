# StringParsing
Assumption:

- String should be balanced with an open bracket [ and a close bracket ]
- Individual elements are delimited with a comma followed by space (e.g., ", ")
- Individual groupings are designated with an open bracket [ and a close bracket ]
- Empty elements are valid only within two commas.

String Parser Algorithm Complexities:

Time Complexity: O(n^2)

In our implementation, 

for(int len = 0; len < list.size(); len++){
	...
	for( int i = 0; i < space_list.get(len); i++){
	.....
	}
}

Here we're nesting two loops. If our array has n items, our outer loop runs n times and our inner loop runs n times for each iteration of the outer loop, giving us n^2 total executions. Thus this method runs in O(n^2)time(or "quadratic time"). 

Space Complexity: O(n)

Usually methods with fixed number of variables take O(1)space but when we create stack or array using new keyword, size of that stack or array scales with size of input. Therefore, space complexity in our code is O(n).

The space complexity is about taking additional space, so we don't include space taken up by the inputs.

Sample input/output of program:

EXAMPLE 1 (Input): [1, 2, [A, B, C, [5^&, )()6, , 7], D, E] 3, 4]
EXAMPLE 1 (Output): 
  1
  2
    A
    B
    C
      5^&
      )()6
       
      7
    D
    E
  3
  4

Continue(Y/N): Y
EXAMPLE 2 (Input): [1, 2, [A, B, C, [5, 6]]
EXAMPLE 2 (Output): 
Invalid!
Continue(Y/N): N
