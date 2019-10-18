S = """# -*- perl -*-
use strict;
use warnings;
use tests::tests;
check_expected ([<<'EOF']);
(my-test-1) begin
(my-test-1) argc = {}
(my-test-1) argv[0] = 'my-test-1'
{}{}
(my-test-1) end
my-test-1: exit(0)
EOF
pass;
"""
N = 80
print(S.format(N, "".join(["(my-test-1) argv[{}] = 'a'\n".format(i) for i in range(1, N)]), '(my-test-1) argv[{}] = null'.format(N)))
