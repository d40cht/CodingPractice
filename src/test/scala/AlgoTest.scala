package org.seacourt.codingpractice

import org.scalatest.{FunSuite, Suite, ParallelTestExecution}

/**
  * To read:
  * 
  * http://research.google.com/pubs/papers.html
  * http://research.google.com/pubs/DistributedSystemsandParallelComputing.html
  */
  

class SortTest extends FunSuite
{
    // Generate a set of arrays to sort
    def evaluateSort( sortFn : Array[Int] => Array[Int] )
    {
        val toSort = (0 until 20).flatMap { l => (0 until 10).map { i => (0 until l).map( v => util.Random.nextInt ).toArray } }.toList
        val v = Array( 1, 5, 2, 3, 1, 6, 8, 1, 9, 10, 15, 13, 12, 4, 5, 3, 6, 9, 7 )
        
        assert( v.sortBy(identity) sameElements sortFn(v) )
        
        for ( s <- toSort )
        {
            assert( s.sortBy(identity) sameElements sortFn(s) )
        }
    }
    
    
    test("MergeSort")
    {
        // In array
        def mergeSort( a : Array[Int] ) =
        {
            val length = a.size
            var from = a.map( identity )
            var to = new Array[Int]( length )
            
            def iteration( span : Int ) =
            {
                def interleave( s : Int, span : Int )
                {
                    var s1 = s
                    var e1 = s + span
                    var s2 = e1
                    var e2 = (s + span*2) min length
                    var out = s
                    while ( out < e2 )
                    {
                        // Left series exhausted
                        if ( s1 >= e1 )
                        {
                            to(out) = from(s2)
                            s2 += 1
                        }
                        // Right series exhausted
                        else if ( s2 >= e2 )
                        {
                            to(out) = from(s1)
                            s1 += 1
                        }
                        else
                        {
                            val l = from(s1)
                            val r = from(s2)
                            if ( l < r )
                            {
                                to(out) = l
                                s1 += 1
                            }
                            else
                            {
                                to(out) = r
                                s2 += 1
                            }
                        }
                        out += 1
                    }
                }
                
                for ( i <- 0 until length by (span*2) )
                {
                    interleave( i, span )
                }
            }
            
            var span = 1
            while( span < length )
            {
                iteration( span )
                val tmp = to
                to = from
                from = tmp
                span *= 2
            }
            
            from
        }
        
        evaluateSort( mergeSort )
    }
    
    test("HeapSort")
    {
    }
    
    test("Quicksort")
    {
    }
}

class HashingTest extends FunSuite
{   
    test("MurmurHash")
    {
    }
    
    test("HashTable")
    {
        // In array
    }
}

class TreeTest extends FunSuite
{
    test("Binary heap")
    {
        // The shape property: the tree is a complete binary tree; that is, all levels of the tree, except possibly the last one (deepest) are fully filled, and, if the last level of the tree is not complete, the nodes of that level are filled from left to right.
        // The heap property: each node is greater than or equal to each of its children according to a comparison predicate defined for the data structure.
        // Add: place new value in next location. Bubble up swapping to maintain the invariant.
        // Remove: Remove top value. Place last value in top location. Bubble down to maintain the invariant.
    }
    
    test("Binary tree")
    {
    }
    
    test("N-ary tree")
    {
    }
    
    test("Trie tree")
    {
        // Prefix tree
    }
    
    test("AA tree")
    {
    }
    
    test("B-tree")
    {
        // Mainly for on disk
    }
}

class TraversalTest extends FunSuite
{
    test("BFS")
    {
        // Inorder, Postorder, Preorder
    }
    
    test("DFS")
    {
        // Inorder, Postorder, Preorder
    }
}

class GraphTest extends FunSuite
{   
    test("Graph - objects and pointers")
    {
    }
    
    test("Graph - matrix")
    {
    }
    
    test("Graph - adjacency list")
    {
    }
    
    test("Topsort")
    {
    }
    
    test("Dijkstra")
    {
    }
}

class NPComplete extends FunSuite
{
    test("Travelling salesman")
    {
    }
    
    test("Knapsack problem")
    {
    }
    
    test("Satisfiability")
    {
    }
}

class DiscreteMath extends FunSuite
{
    test("Permutations")
    {
    }
    
    test("Combinations")
    {
    }
}

class BloomFilter extends FunSuite
{
    test("Bloom filter")
    {
    }
}


class Concurrency extends FunSuite
{
    test("Locks")
    {
    }
    
    test("Mutexes")
    {
        // Mutual exclusion lock
    }
    
    test("Semaphores")
    {
        // Increment (non-blocking) atomically
        // Wait - waits for it to be non-zero then decrements atomically
        // E.g. to mediate access to N instances of a resource
    }
    
    test("Monitors")
    {
        // A code region which only one thread can occupy concurrently
    }
    
    test("Condition variables")
    {
        // Operations: wait - block until notified
        // signal - if anyone is waiting, unblock one thread and let it run
    }
    
    test("Deadlock/livelock")
    {
    }
    
    test("What resource a process needs")
    {
        /*
            * Code, open files, signals, processor and address state, threads, global variables
            * Priorities, resource limits
            
        */
    }
    
    test("What resource a thread needs")
    {
        /*
            * Program counter, process stack, cpu registers
            * Linux doesn't distinguish between processes and threads - just has 'runnable tasks' with variable levels of sharing.
        */
    }
    
    test("How context switching works")
    {
        /*
        * Time spent in saving and restoring processor state (inc. current privilege level)
        * Pollution of processor caches
        * Switching between different processes
         * Virtual memory maps need to be switched
         * Synchronization of memory caches
        *
        * Paging
        
        * State required to save known as the hardware context. x86 has a special segment, the TSS (Task State Segment) to store hardware contexts. Not used by Linux?
        * 
        
        * Linux is able to find best next task to run in O(1).
          * Runqueue has a list per process priority. In smp, each CPU has its own queue.
          * Waitqueue for sleeping/blocked processes
          
        * Page copy on write for forked processes (whcih initially share the parent state)
        */
        
        

    }
    
    
    test("Scheduling")
    {
    }
}



