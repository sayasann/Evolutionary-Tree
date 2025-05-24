# Evolutionary-Tree
📌 Project Overview

This Java project implements an Evolutionary Tree (Phylogenetic Tree) data structure to represent the Tree of Life dataset from the Tree of Life Web Project (ToL). The program provides various functionalities to analyze and traverse the evolutionary relationships between species.
🌳 Dataset Information

The project uses two main data files:

    treeoflife_nodes.csv - Contains species information with the following fields:

        node_id: Numeric identifier

        node_name: Species name

        child_nodes: Number of child nodes

        leaf_node: Whether it's a leaf node

        tolorg_link: Link to ToL web page

        extinct: Extinction status

        confidence: Placement confidence

        phylesis: Monophyletic status

    treeoflife_links.csv - Contains parent-child relationships:

        source_node_id: Parent node

        target_node_id: Child node

🏗️ Data Structure Implementation

The project implements:

    General Tree ADT with nodes that can have multiple children

    Hashtable for O(1) access to species records by ID

    Parent references to track ancestor paths

    Java Collections (List, Stack, Queue) for tree operations

🛠️ Functionalities

The program provides a menu with the following options:

    Load Dataset - Reads and parses the input files to build the tree structure

    Search for Species - Finds and displays details of a species by ID

    Traverse Tree (Pre-order) - Performs pre-order traversal and saves to file

    Print Subtree - Displays a subtree in pre-order format with hierarchical indentation

    Print Ancestor Path - Shows the evolutionary path from root to a given species

    Find Common Ancestor - Identifies the most recent common ancestor of two species

    Tree Statistics - Calculates height, degree, and breadth of the tree

    Longest Evolutionary Path - Finds and displays the longest path(s) in the tree

🚀 How to Run

    Place the data files (treeoflife_nodes.csv and treeoflife_links.csv) in the project directory

    Compile and run the main Java file

    Use the interactive menu to select functionalities


