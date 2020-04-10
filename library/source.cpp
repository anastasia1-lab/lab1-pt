  #include <cstring>
#include <iostream>
#include <vector>
#include <algorithm>
#include "source.h"
using namespace std;

JNIEXPORT jboolean JNICALL Java_com_pt_Main_check(JNIEnv *env, jclass, jstring s1, jstring s2) {
   const char *s1Native = env -> GetStringUTFChars(s1, 0);
   const char *s2Native = env -> GetStringUTFChars(s2, 0);
   size_t lengthS1 = strlen(s1Native);
   size_t lengthS2 = strlen(s2Native);
   if(lengthS1 == lengthS2) {
   vector<char> v1;
   vector<char> v2;
   for(int i = 0; i < lengthS1; i++) {
        v1.push_back(s1Native[i]);
        v2.push_back(s2Native[i]);
   }
   sort(v1.begin(), v1.end());
   sort(v2.begin(), v2.end());
   bool res = v1 == v2;
   v1.clear();
   v2.clear();
   delete[] s1Native;
   delete[] s2Native;
   return res;
   }
   return false;
}