## Design a chat service like Facebook Messenger

### Scoping the product

Assume the answer to all of these is no, but it is interesting to think about how they would be implemented.

- Do we need to support group conversations in addition to 1:1 conversations?
- Do we need to support attachments?
- Do we need to discuss the notification system for new messages?

### Estimation

- What is the reasonable limit to the size of a message?
    - Since it is a chat application, messages will generally be small in size
    - We can say there is a hard limit of 64kb
- Assume each message has 160 chars: 10B messages/day * 160b = 1.6TB/day assuming no metadata

### Things to consider

- Latency is very important; all chat requests should be processed extremely fast
- Consistency is extremely important; if someone sends a sequence of messages, you expect to receive them and vice versa
- Availability is important but consistency wins if choosing between the two
- What operations will we need for this service?
    - Send message, fetch conversations, fetch messages within a conversation
    - For each operation, design the API specifically
    - Think about input/output data
- Database system
  - What is the data schema going to look like?
  - Are we going to have to shard the database? What would the sharding/key strategy look like? (Hint: think about time)
- Error tolerance
  - What happens when a database server goes down? Replication?
  - What happens when app servers go down?
- Scaling
  - We will need load balancers and multiple application servers to handle load
