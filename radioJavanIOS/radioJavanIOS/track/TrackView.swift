//
//  TrackView.swift
//  radioJavanIOS
//
//  Created by Mehrpooya Alinezhad on 4/30/1401 AP.
//  Copyright © 1401 AP orgName. All rights reserved.
//

import SwiftUI
import AVKit

struct TrackView: View {
    @StateObject var vm : TrackViewModel = TrackViewModel.init()
    let id : Int
    
    

    var body: some View {
        ZStack{
        if (vm.error != nil){
            Text(vm.error!)
        }else {
                ZStack{
                    if (vm.trackPhoto != nil){
                        VStack{
                            Spacer()
                }
                        .frame(maxWidth:.infinity,maxHeight: .infinity)
                        .background(Color(hex:vm.backgroundColor ?? "#FFFFFF"))
                        .blur(radius: 50)
                Spacer()
                            .frame(maxWidth:.infinity,maxHeight: .infinity)

                            .background(.black.opacity(0.5))
                        ScrollView{
                        VStack{
                            if (vm.track != nil && !vm.isLoading){
                            Spacer()
                                    .frame(height:50)
                            VideoPlayer(player:vm.player,videoOverlay: {
                                AsyncImage(url: URL(string: (vm.trackPhoto ?? ""))){image in
                                image.resizable()
                                
                            }placeholder: {
                                ProgressView()
                            }

                            })
                            .frame(minWidth:300,maxWidth:400, minHeight:300,maxHeight: 400)
                            .aspectRatio(1, contentMode: .fit)
                            .clipShape(RoundedRectangle(cornerRadius: 10))
                            .shadow(radius: 20)
                            .onAppear {
                                vm.player?.play()
                            }
                            .padding()
                    

                            HStack {
                                Button {
                                    vm.backgroundColor = vm.relateds?.last?.bgColors?.first as! String
                                    vm.onTriggerEvent(id:  Int(vm.relateds?.last?.id ?? 2))
                                    
                                } label: {
                                    Image(systemName: "backward.fill")
                                }
                                .padding()
                                Text((vm.title ?? ""))
                                    .font(.subheadline)
                                Button {
                                    vm.backgroundColor = vm.relateds?.first?.bgColors?.first as! String
                                    vm.onTriggerEvent(id:  Int(vm.relateds?.first?.id ?? 2))
                                    
                                } label: {
                                    Image(systemName: "forward.fill")
                                }
                                .padding()

                            }
                            .foregroundColor(.white)
                            .padding()
                                
                            Spacer()
                                    .frame(height:40)
                                VStack(alignment:.leading){
                                    Text("More Like This ...")
                                        .padding()
                                                .font(.title2.bold())
                                            .foregroundColor(.white)
                                    LazyVGrid(columns:[GridItem(.adaptive(minimum: 100, maximum: 120)),GridItem(.adaptive(minimum: 100, maximum: 120)),GridItem(.adaptive(minimum: 100, maximum: 120))],spacing: 10){
                                        if (vm.relateds != nil){
                                            ForEach(vm.relateds!,id: \.self){ related in
                                                Button {
                                                    vm.backgroundColor = related.bgColors?.first as! String
                                                    vm.onTriggerEvent(id: related.id as! Int)
                                                } label: {
                                                    
                                                

                                                AsyncImage(url: URL( string: related.photo ?? "")){ image in
                                                    image.resizable()
                                                }placeholder: {
                                                    ProgressView()
                                                }
                                                .frame(width: 80, height: 80)
                                                .clipShape(RoundedRectangle(cornerRadius: 10))
                                                .padding(10)
                                                .background(Color(hex: related.bgColors?.first as! String))
                                                .clipShape(RoundedRectangle(cornerRadius: 10))
                                                .shadow(radius: 20)
                                        }
                                        }
                                    }
                                    
                                    }
                                }
                            }
                        }
                        }
                    }
                }

            
        }
    }
        .onAppear {
            vm.onTriggerEvent(id: id)
        }
        
    }
}




extension Color {
    init(hex: String) {
        let hex = hex.trimmingCharacters(in: CharacterSet.alphanumerics.inverted)
        var int: UInt64 = 0
        Scanner(string: hex).scanHexInt64(&int)
        let a, r, g, b: UInt64
        switch hex.count {
        case 3: // RGB (12-bit)
            (a, r, g, b) = (255, (int >> 8) * 17, (int >> 4 & 0xF) * 17, (int & 0xF) * 17)
        case 6: // RGB (24-bit)
            (a, r, g, b) = (255, int >> 16, int >> 8 & 0xFF, int & 0xFF)
        case 8: // ARGB (32-bit)
            (a, r, g, b) = (int >> 24, int >> 16 & 0xFF, int >> 8 & 0xFF, int & 0xFF)
        default:
            (a, r, g, b) = (1, 1, 1, 0)
        }

        self.init(
            .sRGB,
            red: Double(r) / 255,
            green: Double(g) / 255,
            blue:  Double(b) / 255,
            opacity: Double(a) / 255
        )
    }
}
