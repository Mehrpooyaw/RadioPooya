//
//  SearchView.swift
//  radioJavanIOS
//
//  Created by Mehrpooya Alinezhad on 5/1/1401 AP.
//  Copyright © 1401 AP orgName. All rights reserved.
//


import SwiftUI
import radioJavanShared

struct SearchView: View {
    @State var query = ""
    @StateObject var viewModel : SearchViewModel = SearchViewModel.init()
    var body: some View {
        NavigationView{
            VStack{
                HStack{
                    Image(systemName: "magnifyingglass")
                        .foregroundColor(.gray)
                    TextField(text: $query) {
                        Text("Search in RadioPooya...")
                    }
                    Spacer()
                    Button {
                        viewModel.onTriggerEvent(query: query)
                    } label: {
                    Image(systemName: "arrow.right")
                        .foregroundColor(.green)
                        .font(.title2)
                    }
                }
                .padding()
                .overlay(RoundedRectangle(cornerRadius: 20).strokeBorder())
                .shadow(radius: 10)
                .padding()
                Spacer()
                ScrollView{
                    VStack {
                        if (viewModel.results?.mp3s != nil){
                            ForEach(viewModel.results?.mp3s ?? [],id :\.id){ mp3 in
                            NavigationLink (destination : {
                                TrackView(id: Int(truncating: mp3.id ?? 1))
                            }){
                                SearchViewItem(mp3: mp3)
                                    .padding()
                            }
                            
                        }
                        }else if (viewModel.isLoading){
                            ProgressView()
                        }else if( viewModel.error != nil){
                            Text(viewModel.error!)
                        }
                    }
                }
            }
            .navigationTitle("Search")
            .navigationBarTitleDisplayMode(.inline)
        }
    }
}

struct SearchViewItem : View {
    let mp3 : Mp3
    var body: some View {
        HStack{
            AsyncImage(url: URL(string: mp3.photo!)!){image in
                image.resizable()
            }placeholder: {
                ProgressView()
            }
            .frame(width: 80, height: 80)
            .cornerRadius(10)
            .shadow(radius: 10)
            
            VStack(alignment: .leading) {
            
                Text(mp3.title ?? "")
                    .font(.subheadline.bold())
                    .lineLimit(2)
                    .foregroundColor(.white)
                Spacer()
                Text("\(mp3.plays!) plays")
                    .foregroundColor(.white)
                    .font(.caption)
            }
            Spacer()
            
        }
        .padding(5)
        .background(Color(hex: mp3.bgColors?.first as! String))
        .background(.black.opacity(0.5))
        .cornerRadius(10)
        .shadow(radius: 10)
        .padding(5)
    }
}

struct SearchView_Previews: PreviewProvider {
    static var previews: some View {
        SearchView()
    }
}
