# UnionFind
A custom implementation of the union find algorithm


The guiding principle of this implementation is that you have buckets, and connected elements are in the same bucket. The elements are represented with integers.
You can initialize an array of buckets with an 'n' capacity, and it'll have 'n' buckets. 

# `union(a, b)`
The union function will store the actual bucket data in the lowest index of the array, and a reference to that data in the highest index.

Let's look at an example of the union function: `union(0, 1)`.
When performing the union of 0 and 1, the bucket at the zeroeth index in the array of buckets is going to store the values 0 and 1, and so be like '[0, 1]'.
A reference to that bucket will be stored in the index one, represented by `ref(0)`.

So, a bucket array with a capacity of 10 would look like this after the union operation: <br>
`[[0, 1], ref(0), [], [], [], [], [], [], [], []]`.

Let's make another union: `union(8, 9)`.
The array would then look like this: <br>
`[[0, 1], ref(0), [], [], [], [], [], [], [8, 9], ref(8)]`

If we then try to perform the union of 1 and 8 with `union(1, 8)` we would get an array like this: <br>
`[[0, 1, 8, 9], ref(0), [], [], [], [], [], [], ref(1), ref(8)]`
Note that the 8th index now holds a reference to the first index, because it was united with the index one.
Notice that the zeroeth bucket now has 8 and 9 was well, because the 8th bucket was merged with the 0th bucket. 

How did that happen? <br>
When we asked the algorithm to unite 8 and 1, it went to the lowest index, one, so that it could add the highest index, 8, there.
But what it found was a reference to the zeroeth index, so it just followed that breadcrumb and went there instead. 
At the zeroeth index, it didn't find any references to any other bucket, just the actual data, so it add it there.
What was stored in the highest index (8, in this case) was the reference to the lowest index (one, in this case), and so it reads `ref(1)` now.


# `isConnected(a, b)`
The isConnected function is very simple, all it does is go to the bucket in the lowest index and checks to see if the highest index is there.  

If you had a bucket array like this: `[[0, 1, 8, 9], ref(0), [], [], [], [], [], [], ref(1), ref(8)]`, and asked whether 9 and 1 are connected, what would happen is that the algorithm would hit the lowest index, in this case the index one, which would redirect you to the bucket at the zeroeth index. Then it would try to find the highest index (9, in this case) in that bucket. It would then return true if it finds it, or false if it doesn't.



