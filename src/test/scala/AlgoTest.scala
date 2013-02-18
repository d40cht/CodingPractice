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
    test("HashTable")
    {
        // In array
    }
}

class TreeTest extends FunSuite
{   
    test("Binary tree")
    {
    }
    
    test("N-ary tree")
    {
    }
    
    test("Trie tree")
    {
    }
    
    test("AA tree")
    {
    }
    
    test("Binary heap")
    {
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
    }
    
    test("Semaphores")
    {
    }
    
    test("Monitors")
    {
    }
    
    test("Condition variables")
    {
    }
    
    test("Deadlock/livelock")
    {
    }
    
    test("What resource a process needs")
    {
    }
    
    test("What resource a thread needs")
    {
    }
    
    test("How context switching works")
    {
    }
    
    
    test("Scheduling")
    {
    }
}



