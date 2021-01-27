package com.revature.samplr

import org.apache.hadoop.mapreduce.Mapper
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text

class RandomSampleMapper
    extends Mapper[LongWritable, Text, Text, Text] {

  var frac: Double = 0.5;

  override def map(
      key: LongWritable,
      value: Text,
      context: Mapper[LongWritable, Text, Text, Text]#Context
  ): Unit = {
    // pseudorandom decide if the record will be included
    if(Math.random() < frac) {
      //write the line of text out as the key, leaving the value as empty string
      context.write(value, new Text(""))
    }
  }

}
