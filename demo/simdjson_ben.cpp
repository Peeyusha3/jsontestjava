
#include <benchmark/benchmark.h>
#include <iostream>
#include "simdjson.h"
using namespace simdjson;
using namespace ondemand;

static void BM_StringCreation(benchmark::State& state) {
  //for (auto _ : state)
    //std::string empty_string;
    ondemand::parser parser;
    padded_string json = padded_string::load("twitter.json");
    ondemand::document tweets = parser.iterate(json);
    std::cout << uint64_t(tweets["search_metadata"]["count"]) << " results." << std::endl;

    
}
// Register the function as a benchmark
BENCHMARK(BM_StringCreation);

    //std::cout << uint64_t(tweets["search_metadata"]["count"]) << " results." << std::endl;

// Define another benchmark
/*tatic void BM_StringCopy(benchmark::State& state) {
  std::string x = "hello";
  for (auto _ : state)
    std::string copy(x);
}
BENCHMARK(BM_StringCopy);*/

BENCHMARK_MAIN();