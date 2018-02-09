## Design the Twitter newsfeed

### Scoping the product

Assume the answer to all of these is no, but it is interesting to think about how they would be implemented.

- Do we need to support replies to tweets or grouping for conversations?
- What type of privacy controls do we need to think about for these tweets?
- Do we need to support trending tweets?
- Do we need to think about internationalization/localization?
- What about direct messaging?
- What about mentions and tagging?
- Do we need to worry about notifications? 

### Questions to ask/items to convey

- Estimate the number of tweets posted per second that this service will receive
- Estimate the number of timeline requests per second that this service will receive
    - The answers/estimates for these will roughly correlate to the number of writes per second and number of reads per second for the database
    - (~500M tweets/day, 100M daily active users)
- How many followers does the average user have?
    - ~200, but consider the case for the users that have a huge amount of followers. How would they be handled differently?
- How many times is a tweet favorited?
    - Again, ~10-20 times but consider the cases that have >1M favorites

### Things to consider

- How sensitive to latency are these requests?
  - Very sensitive; the system must be very fast
- How consistent do the requests have to be? Is eventual consistency ok?
  - Probably not super important; it’s ok to miss out on a couple of tweets or not get it within a few seconds
- What are the availability requirements? Do we need to be up 100% of the time?
  - Needs to be highly available
- Design the API
  - Consider 4 operations: posting tweet, following user, favoriting tweet, get user feed
  - What does the data input/output look like?
- Database system
  - What is the data schema going to look like?
  - Are we going to have to shard the database? What would the sharding/key strategy look like? (Hint: think about time)
- Error tolerance
  - What happens when a database server goes down? Replication?
  - What happens when app servers go down?
- Scaling
  - We will need load balancers and multiple application servers to handle load

### Challenge

Now assume that we want to improve the user engagement by showing them suggestions on who to follow. These suggestions should be based on their existing network of users. What types of data could we use to make these connections? What additional technology or APIs would we need to make this happen?
