    #include <bits/stdc++.h>
    using namespace std;
    typedef long long ll;
    unordered_map<ll,ll> book_scores;
    class library{
    	public:
    	ll id;
    	ll signup_days;
    	ll shipping_limit;
    	ll no_of_books;
    	vector<ll> books;
    	ll possible_score;
    };
    bool price_function(ll book1, ll book2){
    	return (book_scores[book1] > book_scores[book2]);
    }

    bool lib_score(library l1, library l2){
    	return (l1.possible_score > l2.possible_score);
    }
    ll cal(vector<ll> books, ll rate, ll days){
    	if (days <= 0)
    	return -1;
    	ll score = 0;
    	ll n = books.size();
    	for (int i=0; i< min(days*rate,n);i++){
    //	cout<<books[i]<<" : "<<book_scores[books[i]]<<endl;
    	score += book_scores[books[i]];
    	}
    	return score;

    }
    int main() {
    	ll b,l,d;
    	cin>>b>>l>>d;
    	unordered_map<ll,bool> used_books;

    	for(int i=0;i<b;i++)
    	{
    		ll score;
    		cin>>score;
    		book_scores[i] = score;
    		used_books[i] = false;
    	}
    	vector<library> lib;
    	for(int i=0; i<l; i++){
    		ll n,sp,shiprate;
    		cin>>n>>sp>>shiprate;
    		vector<ll> books;
    		for(int j = 0; j<n;j++)
    		{
    			ll book;
    			cin>>book;
    			books.push_back(book);
    		}
    		sort(books.begin(),books.end(),price_function);
    		ll possible_score = cal(books,shiprate,d-sp);
    		library li;
    		li.id=i;
    		li.books = books, li.signup_days = sp,li.no_of_books = n, li.possible_score = possible_score;
    		lib.push_back(li);
    	}
    	sort(lib.begin(),lib.end(),lib_score);
    	ll days = d;
    	ll no_libs = 0;
    	for(int i=0 ; i< lib.size();i++){
    		if(lib[i].signup_days > days)
    		break;

    	    days -= lib[i].signup_days ;
    	    no_libs++;
    	}
    	cout<<no_libs<<"\n";
    	days = 0;

    	for(int i=0; i< no_libs;i++){
    		days += lib[i].signup_days;
    		ll n = min((d-days)*lib[i].shipping_limit,(ll)lib[i].books.size());
    		cout<<lib[i].id<<" "<<n<<"\n";
    		for(int j=0; j<n; j++){
    		cout<<lib[i].books[j]<<" ";
    		}
    		cout<<"\n";
    	}
    	return 0;
    }
