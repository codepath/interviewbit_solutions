## Design search typeahead

### Questions to ask

- How many requests per second are we going to be receiving?
- Are the searches for users evenly distributed or are we going to see burst traffic for single users at certain times?
- Approx. how many users does this site have?
- Does this API need to be rate limited to prevent against bad clients?
- How many attributes for searching will we support? First/last name, email, phone number etc?

### Things to consider

- Design of the HTTP API for the search should be simplistic
- Indexing for efficient lookups. What happens if we want to add or remove fields that we can use for lookups?
- Caching: how will you prevent against bursts of traffic, or handle a large user space

### Challenge

Now, instead of users, imagine a search typeahead API that searches through user posts and content instead of simple lookup by certain values of the user. What pieces of the implementation will change? What should we add?

The challenge portion of this question requires some thinking outside of the box to use things like full text search and technologies like Elasticsearch to maintain specific indexes on the data.
