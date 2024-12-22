# Restricted Boltzmann Machine (RBM) Sampling and Temperature

## 1. Sampling with a Restricted Boltzmann Machine

### Key Concepts and Steps in the RBM Sampling Process

The RBM uses an energy-based model where the probability of a visible-hidden pair \((v, h)\) is defined using an **energy function**.

#### Energy Function

The energy of the system is given by:

$ E(v, h) = -\sum_i \sum_j W_{ij} v_i h_j - \sum_i b_i v_i - \sum_j c_j h_j $


where:
- \(v_i\): Binary state of visible unit \(i\)
- \(h_j\): Binary state of hidden unit \(j\)
- \(W_{ij}\): Weight between visible unit \(i\) and hidden unit \(j\)
- \(b_i\): Bias of visible unit \(i\)
- \(c_j\): Bias of hidden unit \(j\)

The joint probability of \((v, h)\) is given by:

\[
P(v, h) = \frac{\exp(-E(v, h))}{Z}
\]

where \(Z = \sum_{v,h} \exp(-E(v, h))\) is the **partition function** (normalization constant).

#### Sampling Algorithm

The goal is to sample from the distribution \(P(v)\) of the visible layer, which requires marginalizing out the hidden states:

\[
P(v) = \sum_h P(v, h)
\]

Since direct computation of \(P(v)\) is intractable, the RBM uses **Gibbs Sampling**:

1. **Initialize visible units**: Start with a random vector \(v^{(0)}\) in the visible layer.

2. **Sample hidden units \(h\)**: Compute the conditional probability of each hidden unit \(h_j\) given the visible layer \(v^{(t)}\):

   \[
   P(h_j = 1 \mid v) =
