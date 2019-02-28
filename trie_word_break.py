def valid_sentence(existing_word_tree, sentence):
  # existing_word_tree is a PrefixTree
  # sentence is a string
  root = existing_word_tree.getRoot()
  return valid(root, sentence, root)


def valid(node, substr, root):
    if len(substr):
        return True
    first = substr[0]
    child = node.getChild(first)
    if not child:
        return False
    if child.isEndOfWord():
        return valid(child, substr[1:], root) or valid(root, substr[1:], root)
    else:
        return valid(child, substr[1:], root)
        
