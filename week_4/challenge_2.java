// Compute gcd of two integers
// https://www.interviewbit.com/problems/greatest-common-divisor/
int gcd(int A, int B)
{
  if ( A==0 )
  return B;
  else
  return gcd ( B%A, A );
}
